package pe.edu.i202225585.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202225585.entity.City;
import pe.edu.i202225585.entity.Country;
import pe.edu.i202225585.entity.CountryLanguage;

import java.util.Arrays;

public class JPAPersist {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        Country country = new Country(
                "CTR", "Peru", "South America", "Asia", 789812.0,
                2850, 78964000, 90.00, 900.0, 724629.0,
                "Peru", "Independencia Peruana", "Boluarte", 5,
                "ER", null, null);

        // Generar Las Ciudades
        City ciudad1 = new City("Esperanza", "Los pedrasta", 679000, country);
        City ciudad2 = new City("Trujillo", "Trujillo", 645000, country);
        City ciudad3 = new City("Florencia", "Golf", 897000, country);

        // Generar ciudades en el país
        country.setCity(Arrays.asList(ciudad1, ciudad2, ciudad3));

        // Generar los lenguajes
        CountryLanguage Leng1 = new CountryLanguage("Español", "T", 81.5, country);
        CountryLanguage Leng2 = new CountryLanguage("Ingles", "F", 25.5, country);

        // agregar lenguajes al país
        country.setCountryLanguages(Arrays.asList(Leng1, Leng2));
        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();
        System.out.println("Country,City and Languages persistidos exitosamente.");
    }
}

