# Team

ΑΜ: it21848 Παναγιώτης Κουρπάς  
AM: it21840 Βασίλειος Κατέβας  
AM: it21666 Ιωάννης Παπαγιαννόπουλος 

## Instalation 

 -  Φτιάχνουμε τα tables στην (mysql) βάση (Το αρχείο της βάσης **db_schema.sql**  βρίσκεται στο Repository).
 -  Μετά κάνουμε insert τον admin σαν χρήστη (ο κωδικός του ειναι pass123).
 - Δημιουργώ το αρχείο **jdbc.properties** στον **src** φάκελο. Εκεί κάνω copy past τα:

		  jdbc.url=
		  jdbc.user=
		  jdbc.pass=
		  jdbc.driver=
		  
και τα συμπληρώνουμε

### jdbc.url Παράδειγμα

		jdbc:mysql://localhost:3306/kindergarten?useSSL=false&useUnicode=true&connectionCollation=utf8_general_ci&characterSetResults=utf8&characterEncoding=utf-8

### jdbc.driver Για MySQL βάση

		com.mysql.jdbc.Driver

Η βάση στην συγκεκριμένη περίπτωση λέγεται kindergarten και είναι localhost στο user βάζω το όνομα του user και στον password τον κωδικό της βάσης.

---
Το project τρέχει σε Tomcat server οταν το τρέξουμε πάμε στο [localhost:8080/backSystem] στον Browser μας. Εκεί κάνουμε login με τα στοιχεία του Admin(username: admin password:pass123). Μόλις κάνουμε login μπορούμε να κάνουμε register, update, read, delete τους άλλους 2 χρήστες του εσωτερικού μας συστήματος.

