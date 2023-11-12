package bancodadosII.firestore.service;

import bancodadosII.firestore.model.Prova;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class ProvaService {
    /**
     * TODO updateProva
     * TODO deleteProva
     */
    private static final String COLLECTION_NAME = "prova";

    @SneakyThrows
    public String saveProva(Prova prova)  {

        Firestore fireStoreDB = FirestoreClient.getFirestore();
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

    @SneakyThrows
    public String deletarProvaPeloId(String idProva){

        Firestore firestoreDB = FirestoreClient.getFirestore();
        firestoreDB.collection(COLLECTION_NAME).document(idProva).delete();
        return "Prova com ID : " + idProva + " foi deletada com sucesso";

    }

    @SneakyThrows
    public Prova atualizarProvaPeloId(String idProva, Prova prova) {

        Firestore fireStoreDB = FirestoreClient.getFirestore();
        CollectionReference colecaoProvas = fireStoreDB.collection(COLLECTION_NAME);
        colecaoProvas.document(idProva).set(prova);

        return prova;

    }

    @SneakyThrows
    public List<Prova> buscarTodasProvas() {

        Firestore fireStoreDB = FirestoreClient.getFirestore();
        CollectionReference colecaoProvas = fireStoreDB.collection(COLLECTION_NAME);

        ApiFuture<QuerySnapshot> query = colecaoProvas.get();
        QuerySnapshot querySnapshot = query.get();


        List<QueryDocumentSnapshot> provas = querySnapshot.getDocuments();

        return provas.stream()
                .map((prova) -> prova.toObject(Prova.class))
                .toList();


    }
}
