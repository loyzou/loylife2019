package org.loy.util;

import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("loyService")
public class LoyServiceImpl implements LoyService {
    @Override
    public void say() {
        System.out.println("say loy....");
    }
}
