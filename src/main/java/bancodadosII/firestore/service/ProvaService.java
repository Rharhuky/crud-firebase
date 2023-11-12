package bancodadosII.firestore.service;

import bancodadosII.firestore.model.Prova;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;


@Service
public class ProvaService {

    private static final String COLLECTION_NAME = "prova";

    @SneakyThrows
    public String saveProva(Prova prova)  {

        Firestore fireStoreDB = FirestoreClient.getFirestore();

//      ApiFuture<WriteResult> colecaoApiFuture =  fireStoreDB.collection(COLLECTION_NAME).document(pessoa.getNome()).set(pessoa);

        DocumentReference docReferencia = fireStoreDB.collection(COLLECTION_NAME).add(prova).get();

        return docReferencia.getId();
    }

    @SneakyThrows
    public Prova buscarProvaPeloId(String idProva)  {
        Firestore firestoreDB = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestoreDB.collection(COLLECTION_NAME).document(idProva);

        ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = documentReference.get();
        DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();

        return documentSnapshot.toObject(Prova.class);
    }
}
