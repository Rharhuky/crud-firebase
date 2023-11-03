package bancodadosII.firestore;

import bancodadosII.firestore.model.Pessoa;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class PessoaService {

    private static final String COLLECTION_NAME = "pessoas";

    public String saveProduct(Pessoa pessoa) throws ExecutionException, InterruptedException {

        Firestore fireStoreDB = FirestoreClient.getFirestore();
        /*
        O doc leva o nome que eu definit no parâmetro
         */
//        ApiFuture<WriteResult> colecaoApiFuture =  fireStoreDB.collection(COLLECTION_NAME).document(pessoa.getNome()).set(pessoa);

        /*
        Dessa forma, será gerado o ID
         */
        DocumentReference docReferencia =  fireStoreDB.collection(COLLECTION_NAME).add(pessoa).get();

        return docReferencia.getId() ;
    }

}
