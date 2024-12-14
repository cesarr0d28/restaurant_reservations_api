package reservaciones_restaurante;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import com.reservaciones_restaurante.ReservacionesRestauranteApplication;

@SpringBootTest(classes = ReservacionesRestauranteApplication.class)
class ReservacionesRestauranteApplicationTests {

    @Autowired
    private ReservacionesRestauranteApplication application;

    @Test
    void contextLoads() {
        // Verificar que el contexto se cargue correctamente
        assertThat(application).isNotNull();
    }
}
