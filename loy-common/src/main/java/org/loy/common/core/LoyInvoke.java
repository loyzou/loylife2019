package org.loy.common.core;

import org.loy.common.context.LoyParam;
import org.loy.common.context.LoyResult;

/***
 * 调用
 */
public interface LoyInvoke {
    LoyResult invoke(LoyParam params);
}
