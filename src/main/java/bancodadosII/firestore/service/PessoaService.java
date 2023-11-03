package bancodadosII.firestore.service;

import bancodadosII.firestore.model.Pessoa;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class PessoaService {

    private static final String COLLECTION_NAME = "pessoas";

    public String savePessoa(Pessoa pessoa) throws ExecutionException, InterruptedException {

        Firestore fireStoreDB = FirestoreClient.getFirestore();

//      ApiFuture<WriteResult> colecaoApiFuture =  fireStoreDB.collection(COLLECTION_NAME).document(pessoa.getNome()).set(pessoa);

        DocumentReference docReferencia = fireStoreDB.collection(COLLECTION_NAME).add(pessoa).get();

        return docReferencia.getId() ;
    }

    public Pessoa getPessoa(String nome){

        Firestore firestoreDB = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestoreDB.collection(COLLECTION_NAME).document(nome);

        ApiFuture<DocumentSnapshot> documentSnapshotApiFuture =  documentReference.get();
        DocumentSnapshot documentSnapshot = null;
        try {

            documentSnapshot = documentSnapshotApiFuture.get();
            return documentSnapshot.toObject(Pessoa.class);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }

    }

}
