import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;


public class App {
    public static void main(String[] args) {
        try {
           String databaseUrl = "jdbc:sqlite:LABO1/Magasin.db";
           ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

            TableUtils.createTableIfNotExists(connectionSource, Produit.class);
            ProduitDao dao = new ProduitDao(connectionSource);

        
            System.out.println("Lancement de la caisse...");
            Thread caisse1 = new Thread(new CaisseService(dao));
            caisse1.start();

            // Pour simuler plusieurs caisses, tu peux lancer plus de threads ici :
            // Thread caisse2 = new Thread(new CaisseService(dao));
            // Thread caisse3 = new Thread(new CaisseService(dao));
            // caisse2.start(); caisse3.start();

            caisse1.join();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}