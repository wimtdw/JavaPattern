package javalabs;

import org.springframework.stereotype.Component;

@Component
public class RonWeasley implements Magician{
    @Override
    public void doMagic() {
        System.out.println("Ron: Vingardium Leviosa");
    }
}
