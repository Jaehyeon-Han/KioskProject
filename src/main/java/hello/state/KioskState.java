package hello.state;

import hello.domain.Kiosk;

public interface KioskState {
    void execute(Kiosk context);
}
