import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import tests_examen_sgbd.Employee;

public class TestEmployee {
    private static Employee employee;

    @BeforeAll
    static void setup() {
        TestEmployee.employee = new Employee();
    }

    @Nested
    @DisplayName("Validation du mot de passe")
    public class checkPassword {

        @Test
        @DisplayName("Mot de passe valide")
        public void verifierMotDePasseValide() {
            Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(true, employee.checkPassword("Azerty12"));
                },
                () -> {
                    Assertions.assertEquals(true, employee.checkPassword("A1B2C3D4E5f"));
                }
            );
        }

        @Test
        @DisplayName("Mot de passe vide")
        public void verifierMotDePasseVide() {
            Assertions.assertEquals(false, employee.checkPassword(""));
        }

        @Test
        @DisplayName("Mot de passe sans chiffre")
        public void verifierMotDePasseTropCourt() {
            Assertions.assertEquals(false, employee.checkPassword("azerty"));
        }

        @Test
        @DisplayName("Mot de passe sans majuscule")
        public void verifierMotDePasseSansMajuscule() {
            Assertions.assertEquals(false, employee.checkPassword("aaaaaaaaaa"));
        }

        @Test
        @DisplayName("Mot de passe sans minuscule")
        public void verifierMotDePasseSansMinuscule() {
            Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(false, employee.checkPassword("A1111111"));
                },
                () -> {
                    Assertions.assertEquals(false, employee.checkPassword("A1B2C3D4E5"));
                }
            );
        }
    }

    @Nested
    @DisplayName("Validation du nom d'utilisateur")
    public class checkNomDUtilisateur {

        @ParameterizedTest
        @ValueSource(strings = {"Lambrecq", "lambrecq", "_Lambrecq", "LaMbReCq", "Lambrecq1234"})
        @DisplayName("Nom d'utilisateur valide")
        public void verifierNomDUtilisateurValide(String userName) {
            Assertions.assertEquals(true, employee.checkUserName(userName));
        }

        @Test
        @DisplayName("Nom d'utilisateur vide")
        public void verifierNomDUtilisateurVide() {
            Assertions.assertEquals(false, employee.checkUserName(""));
        }

        @Test
        @DisplayName("Nom d'utilisateur commençant par un chiffre")
        public void verifierNomDUtilisateurCommencantParUnChiffre() {
            Assertions.assertEquals(false, employee.checkUserName("1234Lambrecq"));
        }

        @Test
        @DisplayName("Nom d'utilisateur sans lettre")
        public void verifierNomDUtilisateurSansLettre() {
            Assertions.assertEquals(false, employee.checkUserName("123123123123"));
        }
    }

    @Nested
    @DisplayName("Validation du poste")
    public class checkPoste {

        @Test
        @DisplayName("Poste contenant des chiffres")
        public void verifierPosteAvecChiffres() {
            Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(false, employee.checkRole("123employé"));
                },
                () -> {
                    Assertions.assertEquals(false, employee.checkRole("123312"));
                },
                () -> {
                    Assertions.assertEquals(false, employee.checkRole("Lambrecq1234"));
                }
            );
        }

        @Test
        @DisplayName("Poste vide")
        public void verifierPosteVide() {
            Assertions.assertEquals(false, employee.checkRole(""));
        }

        @Test
        @DisplayName("Poste contenant des majuscules")
        public void verifierPosteContenantDesMajuscules() {
            Assertions.assertEquals(true, employee.checkRole("MaNaGeur"));
        }

        @Test
        @DisplayName("Poste contenant un underscore")
        public void verifierPosteContenantUnUnderscore() {
            Assertions.assertEquals(true, employee.checkRole("Mana_geur"));
        }

        @Test@DisplayName("Poste classique")
        public void verifierPosteClassique() {
            Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(true, employee.checkRole("Employée"));
                },
                () -> {
                    Assertions.assertEquals(true, employee.checkRole("Manager"));
                }
            );
        }
    }
}
