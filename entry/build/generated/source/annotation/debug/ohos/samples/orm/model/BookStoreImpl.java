// Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
package ohos.samples.orm.model;

import java.io.File;
import java.util.Arrays;
import ohos.data.orm.DowngradeComparator;
import ohos.data.orm.OrmMigration;
import ohos.data.orm.UpgradeComparator;
import ohos.data.rdb.RdbOpenCallback;
import ohos.data.rdb.RdbStore;

/**
 * Generated by ohos.data.orm.processor for ohos.samples.orm.model.BookStore. Do not modify!
 *
 * @author Huawei
 * @since 2021-07-20
 */
public class BookStoreImpl extends BookStore {
    private OrmMigration[] upgradeMigrations;

    private OrmMigration[] downgradeMigrations;

    public BookStoreImpl() {
        super();
        this.upgradeMigrations = null;
        this.downgradeMigrations = null;
    }

    public BookStoreImpl(OrmMigration[] upgradeMigrations, OrmMigration[] downgradeMigrations) {
        super();
        this.upgradeMigrations = upgradeMigrations;
        this.downgradeMigrations = downgradeMigrations;
    }

    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public RdbOpenCallback getHelper() {
        return new RdbOpenCallback() {
            @Override
            public void onUpgrade(RdbStore store, int oldVersion, int newVersion) {
                if (upgradeMigrations != null) {
                    Arrays.sort(upgradeMigrations, new UpgradeComparator());
                    for (OrmMigration migration : upgradeMigrations) {
                        if (migration.getBeginVersion() >= oldVersion && migration.getEndVersion() <= newVersion) {
                            migration.onMigrate(store);
                        }
                    }
                }
            }

            @Override
            public void onDowngrade(RdbStore store, int oldVersion, int newVersion) {
                if (downgradeMigrations != null) {
                    Arrays.sort(downgradeMigrations, new DowngradeComparator());
                    for (OrmMigration migration : downgradeMigrations) {
                        if (migration.getBeginVersion() <= oldVersion && migration.getEndVersion() >= newVersion) {
                            migration.onMigrate(store);
                        }
                    }
                }
            }

            @Override
            public void onCorruption(File databaseFile) {
                corruptionHandler(databaseFile);
            }

            @Override
            public void onCreate(RdbStore store) {
                store.executeSql("CREATE TABLE IF NOT EXISTS `AllDataType` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `integerValue` INTEGER , `longValue` INTEGER , `shortValue` INTEGER , `booleanValue` INTEGER , `doubleValue` REAL , `floatValue` REAL , `stringValue` TEXT , `blobValue` BLOB , `clobValue` TEXT , `byteValue` INTEGER , `dateValue` INTEGER , `timeValue` INTEGER , `timestampValue` INTEGER , `calendarValue` INTEGER , `characterValue` TEXT , `primIntValue` INTEGER , `primLongValue` INTEGER  NOT NULL, `primShortValue` INTEGER  NOT NULL, `primFloatValue` REAL  NOT NULL, `primDoubleValue` REAL  NOT NULL, `primBooleanValue` INTEGER  NOT NULL, `primByteValue` INTEGER  NOT NULL, `primCharValue` TEXT , `order` INTEGER )");
                store.executeSql("CREATE TABLE IF NOT EXISTS `user` (`userId` INTEGER PRIMARY KEY AUTOINCREMENT, `firstName` TEXT , `lastName` TEXT , `age` INTEGER , `balance` REAL  NOT NULL, `useTimestamp` INTEGER  NOT NULL)");
                store.executeSql("CREATE INDEX `index_name_index` ON `user` (`firstName`,`lastName`)");
                store.executeSql("CREATE TABLE IF NOT EXISTS `Book` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `Name` TEXT , `user_id` INTEGER , FOREIGN KEY (`user_id`) REFERENCES `user` (`userId`) ON UPDATE NO ACTION ON DELETE CASCADE)");
                store.executeSql("CREATE INDEX `index_Book_Name` ON `Book` (`Name`)");
            }
        };
    }
}
