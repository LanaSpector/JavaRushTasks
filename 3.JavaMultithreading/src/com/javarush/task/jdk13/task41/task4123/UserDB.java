package com.javarush.task.jdk13.task41.task4123;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.util.Objects.isNull;

public class UserDB {

    private volatile Map<Integer, User> users;

    private void initDB() throws Exception {
        if (isNull(users)) {
            synchronized (this) {
                if (isNull(users)) {
                    Map<Integer, User> map = new HashMap<>();
                    for (int i = 0; i < 100; i++) {
                        map.put(i, new User(i, "user" + i));
                        TimeUnit.MILLISECONDS.sleep(1);
                    }
                    users = map;
                }
            }
        }
    }

    public Map<Integer, User> getDB() throws Exception {
        initDB();
        return users;
    }
}
