package org.loy.util;

import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("sufowService")
public class SufowServiceImpl implements LoyService {
    @Override
    public void say() {
        System.out.println("say sufow....");
    }
}
