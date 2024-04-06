package javalabs;

import org.springframework.stereotype.Component;

@Component
public class HarryPotter implements Magician{
    @Override
    public void doMagic() {
        System.out.println("Harry: Patronus");
    }
}
