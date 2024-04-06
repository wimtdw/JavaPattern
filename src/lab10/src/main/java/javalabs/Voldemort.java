package javalabs;

import org.springframework.stereotype.Component;

@Component
public class Voldemort implements Magician{
    @Override
    public void doMagic() {
        System.out.println("Voldemort: Avada Kedavra");
    }
}
