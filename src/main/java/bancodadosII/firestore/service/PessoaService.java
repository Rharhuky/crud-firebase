package bancodadosII.firestore.service;

import bancodadosII.firestore.model.Pessoa;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
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

        return docReferencia.getId();
    }

    public Pessoa getPessoa(String nome) {

        Firestore firestoreDB = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestoreDB.collection(COLLECTION_NAME).document(nome);

        ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = documentReference.get();
        DocumentSnapshot documentSnapshot = null;
        try {

            documentSnapshot = documentSnapshotApiFuture.get();
            return documentSnapshot.toObject(Pessoa.class);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }

    }
/*

    public Pessoa updatePessoa(Pessoa pessoa) {

        Firestore firestoreDB = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestoreDB.collection(COLLECTION_NAME).document(pessoa.getNome());
        ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = documentReference.get();

        DocumentSnapshot documentSnapshot = null;
        try {
            documentSnapshot = documentSnapshotApiFuture.get();

            if (documentSnapshot.exists()) {

                documentReference.set(pessoa);
                return documentReference.get().get().toObject(Pessoa.class);
            }
            return null;

        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace();
            return null;
        }
    }
 */

    /**
     * Atualizar Pessoa através do nome
     * @param novaPessoa
     * @return
     */
    public Pessoa updatePessoa(Pessoa novaPessoa){

        Firestore firestoreDB = FirestoreClient.getFirestore();
        try {

            CollectionReference pessoaCollectionReference = firestoreDB.collection(COLLECTION_NAME);
            Query query = pessoaCollectionReference.whereEqualTo("nome", novaPessoa.getNome());

            ApiFuture<QuerySnapshot> querySnapshotApiFuture = query.get();
            QuerySnapshot querySnapshot = querySnapshotApiFuture.get();

            if(! querySnapshot.isEmpty()) {
                DocumentSnapshot documentSnapshot = querySnapshot.getDocuments().get(0);
                documentSnapshot.getReference().set(novaPessoa);
                return novaPessoa;
            }
            return null;
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }

    }

}


