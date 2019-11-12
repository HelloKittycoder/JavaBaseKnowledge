package com.kittycoder.ex05.bean.a;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by shucheng on 2019-11-12 下午 20:07
 */
public class UserImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 返回全类名的bean
        return new String[]{"com.kittycoder.ex05.bean.a.User01",
            "com.kittycoder.ex05.bean.a.User02"};
    }
}
