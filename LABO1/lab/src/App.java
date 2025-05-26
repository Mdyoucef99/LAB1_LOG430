import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;


public class App {
    public static void main(String[] args) {
        try {
            // 🔁 Connexion PostgreSQL (modifie selon tes infos)
            String databaseUrl = "jdbc:postgresql://localhost:5432/magasin";
            String user = "magasin_user";
            String password = "magasinpswd";
            ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl, user, password);

            // ✅ Crée la table si elle n'existe pas
            TableUtils.createTableIfNotExists(connectionSource, Produit.class);

            ProduitDao dao = new ProduitDao(connectionSource);

            // ✅ Initialiser quelques produits (uniquement si la table est vide)
            if (dao.getInventaire().isEmpty()) {
                dao.ajouterProduit(new Produit(1, "Pain", "Nourriture", 2.5, 100));
                dao.ajouterProduit(new Produit(2, "Lait", "Nourriture", 1.8, 50));
                dao.ajouterProduit(new Produit(3, "Savon", "Autre", 3.2, 30));
                System.out.println("Produits ajoutés à la base PostgreSQL.");
            }

            // ✅ Lancer un thread de caisse
            System.out.println("Lancement de la caisse...");
            Thread caisse1 = new Thread(new CaisseService(dao));
            caisse1.start();
            caisse1.join();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}