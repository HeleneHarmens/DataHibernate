package no.noroff.DataHibernate;

import no.noroff.DataHibernate.models.Users;
import no.noroff.DataHibernate.models.Characters;
import no.noroff.DataHibernate.models.Classes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class DataHibernateApplication {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY =
			Persistence.createEntityManagerFactory("mamps");

	/**
	 * MAIN METHOD
	 */
	public static void main(String[] args) {

		SpringApplication.run(DataHibernateApplication.class, args);


		/*_____________ADD/CREATE TO TABLE__________________________*/
		//addUser("Marianne", "marri@hotmail.com", "elefant");

		//addCharacter(9, "SuperCraig", "Paladin", 8);

		//addClass("Druid", "'Entangling Roots', 'Shapeshifting'");
		//addClass("Hunter", "'Disengage', 'MultiShot'");
		//addClass("Mage", "'Polymorph', 'Shapeshifting'");
		//addClass("Paladin", "'Judgement', 'Blade of Justice'");
		//addClass("Warlock", "'Felbolt', 'Summon Imp'");
		//addClass("Rogue", "'Blind', 'Pick Pocket'");

		/*_____________PRINT OUT TO CONSOLE__________________________*/
		printUsers();
		printCharacters();
		printClasses();

		/*_____________OTHER INFO_____________________________________*/
		getCharactersFromUser(1);

	}



	/*______METHODS: GET ALL______________________________________________________________________________*/


	/** GET ALL USERS
	 * @return all users
	 */
	public static List<Users> getUsers(){
		List<Users> userList = null;

		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try{
			transaction = manager.getTransaction();
			transaction.begin();

			userList = manager.createQuery("SELECT s FROM Users s",
					Users.class).getResultList();

			transaction.commit();
		}catch (Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			manager.close();
		}

		return userList;
	}


	/** GET ALL USERS
	 * @return all users
	 */
	public static List<Users> getUserNameEmail(){
		List<Users> userList = null;

		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try{
			transaction = manager.getTransaction();
			transaction.begin();

			userList = manager.createQuery("SELECT s FROM Users s",
					Users.class).getResultList();

			transaction.commit();
		}catch (Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			manager.close();
		}

		return userList;
	}


	/** GET ALL CHARACTERS
	 *
	 * @return all characters
	 */
	public static List<Characters> getCharacters(){
		List<Characters> characterList = null;

		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try{
			transaction = manager.getTransaction();
			transaction.begin();

			characterList = manager.createQuery("SELECT s FROM Characters s",
					Characters.class).getResultList();

			transaction.commit();
		}catch (Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			manager.close();
		}

		return characterList;
	}


	/** GET ALL CLASSES
	 *
	 * @return all classes
	 */
	public static List<Classes> getClasses(){
		List<Classes> classList = null;

		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try{
			transaction = manager.getTransaction();
			transaction.begin();

			classList = manager.createQuery("SELECT s FROM Classes s",
					Classes.class).getResultList();
			transaction.commit();
		}catch (Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			manager.close();
		}

		return classList;
	}


	/*______METHODS: GET SINGLE______________________________________________________________________________*/


	/** GET SINGLE USER BASED ON ID
	 *
	 * @param ID id of user
	 * @return selected user
	 */
	public static Users getUser (int ID) {
		Users usr = null;

		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try{
			transaction = manager.getTransaction();
			transaction.begin();

			usr = manager.createQuery("SELECT s FROM Users s WHERE s.userID= :ID" ,
					Users.class).setParameter("ID",ID).getSingleResult();

			transaction.commit();
		}catch (Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			manager.close();
		}

		return usr;
	}


	/** GGET SINGLE CHARACTER BASED ON ID
	 *
	 * @param ID id of character
	 * @return selected character
	 */
	public static Characters getCharacter(int ID){
		Characters chr = null;

		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try{
			transaction = manager.getTransaction();
			transaction.begin();

			chr = manager.createQuery("SELECT s FROM Characters s WHERE s.characterID= :ID" ,
					Characters.class).setParameter("ID",ID).getSingleResult();

			transaction.commit();
		}catch (Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			manager.close();
		}

		return chr;
	}





	/** GET SINGLE CLASS BASED ON CLASS NAME
	 *
	 * @param className name of class ("type")
	 * @return selected class
	 */
	public static Classes getClass(String className){
		Classes cls = null;

		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try{
			transaction = manager.getTransaction();
			transaction.begin();

			cls = manager.createQuery("SELECT s FROM Classes s WHERE s.className= :className" ,
					Classes.class).setParameter("className",className).getSingleResult();

			transaction.commit();
		}catch (Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			manager.close();
		}

		return cls;
	}


	/*______METHODS: ADD THROUGH MAIN METHOD_____________________________________________________________________*/


	/** ADD USER IN MAIN METHOD
	 *
	 * @param userName user's name
	 * @param userEmail user's email
	 * @param userPassword user's password
	 */
	private static void addUser(String userName, String userEmail, String userPassword){
		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try{
			transaction = manager.getTransaction();
			transaction.begin();

			Users newUser = new Users();
			newUser.setUserName(userName);
			newUser.setUserEmail(userEmail);
			newUser.setUserPassword(userPassword);

			manager.persist(newUser);

			transaction.commit();
		}catch (Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			manager.close();
		}
	}


	/** ADD CHARACTER IN MAIN METHOD
	 *
	 * @param userID id of user
	 * @param characterName character's name
	 * @param className name of class ("type")
	 * @param characterLvl character LVL
	 */
	private static void addCharacter(int userID, String characterName, String className, int characterLvl){
		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try{
			transaction = manager.getTransaction();
			transaction.begin();

			Characters newCharacter = new Characters();

			newCharacter.setUserID(userID);
			newCharacter.setCharacterName(characterName);
			newCharacter.setClassName(className);
			newCharacter.setCharacterLvl(characterLvl);

			manager.persist(newCharacter);

			transaction.commit();
		}catch (Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			manager.close();
		}
	}


	/** ADD CLASS IN MAIN METHOD
	 *
	 * @param className name of class ("type")
	 */
	private static void addClass(String className, String abilities){
		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try{
			transaction = manager.getTransaction();
			transaction.begin();

			Classes newClass = new Classes();

			//newCharacter.setUserID(userID);
			newClass.setClassName(className);
			//newClass.setAbilities(className);
			newClass.setAbilities(abilities);

			manager.persist(newClass);

			transaction.commit();
		}catch (Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			manager.close();
		}
	}



	/*______METHODS: ADD THROUGH JSON_____________________________________________________________________*/


	/** ADD NEW USER IN JSON
	 *
	 * @param newUser new user
	 */
	public static void addUser(Users newUser){
		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try{
			transaction = manager.getTransaction();
			transaction.begin();

			manager.persist(newUser);

			transaction.commit();
		}catch (Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			manager.close();
		}
	}


	/** ADD NEW CHARACTER IN JSON
	 *
	 * @param newChar new character
	 */
	public static void addCharacter(Map<String, String> newChar){
		int userID = Integer.parseInt(newChar.get("userID"));
		String characterName = newChar.get("characterName");
		String className = newChar.get("className");
		int characterLvl = Integer.parseInt(newChar.get("characterLvl"));

		addCharacter(userID, characterName, className, characterLvl);
	}




	/*______METHODS: PRINT_____________________________________________________________________*/


	public static void printUsers(){
		System.out.println("\nUSERS:");
		for (Users usr: getUsers()) {
			System.out.println(usr.toString());
		}
	}

	public static void printCharacters(){
		System.out.println("\nCHARACTERS:");
		for (Characters ch: getCharacters()) {
			System.out.println(ch.toString());
		}
	}

	public static void printClasses(){
		System.out.println("\nCLASSES & ABILITIES:");
		for (Classes cl: getClasses()) {
			System.out.println(cl.toString());
		}
	}

	public static void getCharactersFromUser(int ID){

		System.out.println("\nCharacter(s) from user: "+ID);
		boolean charIsFound = false;
		for (Characters ch: getCharacters()) {
			if (Integer.parseInt(ch.returnUserID(ID)) == ID) {
				charIsFound = true;
				System.out.println(ch);
			}
		}

		if (charIsFound == false){
			System.out.println("No characters found");
		}
		System.out.println();
	}


}
