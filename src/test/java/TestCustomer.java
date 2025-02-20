import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import tests_examen_sgbd.Customer;

public class TestCustomer {
    private static Customer customer;

    @BeforeAll
    static void setup() {
        TestCustomer.customer = new Customer();
    }
    
    @Nested
    @DisplayName("Validation de l'adresse mail")
    public class emailValidation {

        @Test
        @DisplayName("Adresse mail simple")
        public void verifierEmailSimple() {
            Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(true, customer.verifierEmail("test@test.com"));             
                },
                () -> {
                    Assertions.assertEquals(true, customer.verifierEmail("TEST@TEST.com"));
                }
            );
        }

        @Test
        @DisplayName("Adresse mail avec des chiffres")
        public void verifierEmailAvecChiffres() {
            Assertions.assertEquals(true, customer.verifierEmail("1234@5678.com"));
        }

        @Test
        @DisplayName("Adresse mail vide")
        public void verifierEmailVide() {
            Assertions.assertEquals(false, customer.verifierEmail(""));
        }

        @Test
        @DisplayName("Adresse mail au format incorrect")
        public void verifierEmailIncorrect() {
            Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(false, customer.verifierEmail("TEST"));
                },
                () -> {
                    Assertions.assertEquals(false, customer.verifierEmail("test@test"));
                },
                () -> {
                    Assertions.assertEquals(false, customer.verifierEmail("test@test."));
                },
                () -> {
                    Assertions.assertEquals(false, customer.verifierEmail("test.com"));
                }
            );
        }
    }

    @Nested
    @DisplayName("Validation du numero de telephone")
    public class phoneValidation {

        @Test
        @DisplayName("Numero de téléphone au format correct")
        public void verifierTelephoneFormatCorrect() {
            Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(true, customer.verifierTelephone("+32470123456"));
                },
                () -> {
                    Assertions.assertEquals(true, customer.verifierTelephone("0470123456"));
                },
                () -> {
                    Assertions.assertEquals(true, customer.verifierTelephone("0032470123456"));
                },
                () -> {
                    Assertions.assertEquals(true, customer.verifierTelephone("0470/12.34.56"));
                }
            );
        }

        @Test
        @DisplayName("Numero de téléphone vide")
        public void verifierTelephoneVide() {
            Assertions.assertEquals(false, customer.verifierTelephone(""));
        }

        @Test
        @DisplayName("Numero de téléphone au format incorrect")
        public void verifierTelephoneIncorrect() {
            Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(false, customer.verifierTelephone("0"));
                },
                () -> {
                    Assertions.assertEquals(false, customer.verifierTelephone("AZE"));
                },
                () -> {
                    Assertions.assertEquals(false, customer.verifierTelephone("+3247012345AB"));
                },
                () -> {
                    Assertions.assertEquals(false, customer.verifierTelephone("+3247012345"));
                },
                () -> {
                    Assertions.assertEquals(false, customer.verifierTelephone("=32470123456"));
                }
            );
        }
    }

    @Nested
    @DisplayName("Validation du nom")
    public class verifierNom {

        @Test
        @DisplayName("Nom correct")
        public void verifierNomCorrect() {
            Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(true, customer.verifierNom("Lambrecq"));
                },
                () -> {
                    Assertions.assertEquals(true, customer.verifierNom("lambrecq"));
                },
                () -> {
                    Assertions.assertEquals(true, customer.verifierNom("LaMbReCq"));
                }
            );
        }

        @Test
        @DisplayName("Nom vide")
        public void verifierNomVide() {
            Assertions.assertEquals(false, customer.verifierNom(""));
        }

        @Test
        @DisplayName("Nom contenant des chiffres")
        public void verifierNomAvecChiffres() {
            Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(false, customer.verifierNom("Lambrecq1234"));
                },
                () -> {
                    Assertions.assertEquals(false, customer.verifierNom("1234Lambrecq"));
                }
            );
        }

        @Test
        @DisplayName("Nom au format incorrect")
        public void verifierNomIncorrect() {
            Assertions.assertEquals(false, customer.verifierNom("_Lambrecq@"));
        }
    }
} 
    
