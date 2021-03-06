// Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
package ohos.samples.orm.model;

import java.util.List;
import ohos.data.IllegalPredicateException;
import ohos.data.orm.EntityHelper;
import ohos.data.orm.OrmPredicates;
import ohos.data.rdb.Statement;
import ohos.data.resultset.ResultSet;

/**
 * Generated by ohos.data.orm.processor for BookUpgrade in ohos.samples.orm.model.BookStoreUpgrade. Do not modify!
 *
 * @author Huawei
 * @since 2021-07-20
 */
public class BookUpgradeHelper implements EntityHelper<BookUpgrade> {
    private static final BookUpgradeHelper INSTANCE = new BookUpgradeHelper();

    private static final String INSERT_STATEMENT = "INSERT INTO `BookUpgrade` (`id`, `Name`, `user_id`, `addColumn12`) VALUES (?,?,?,?)";

    private static final String UPDATE_STATEMENT = "UPDATE `BookUpgrade` Set `id` = ?, `Name` = ?, `user_id` = ?, `addColumn12` = ? WHERE `rowid` = ?";

    private static final String DELETE_STATEMENT = "DELETE FROM `BookUpgrade` WHERE `rowid` = ?";

    private BookUpgradeHelper() {
    }

    public static BookUpgradeHelper getInstance() {
        return INSTANCE;
    }

    @Override
    public void bindValue(Statement statement, BookUpgrade object) {
        Integer id = object.getId();
        if (id != null) {
            statement.setLong(1, id);
        } else {
            statement.setNull(1);
        }
        String name = object.getName();
        if (name != null) {
            statement.setString(2, name);
        } else {
            statement.setNull(2);
        }
        statement.setLong(3, object.getUserId());
        statement.setLong(4, object.getAddColumn12());
    }

    @Override
    public void bindValue(Statement statement, BookUpgrade object, long id) {
        this.bindValue(statement, object);
        statement.setLong(5, id);
    }

    @Override
    public BookUpgrade createInstance(ResultSet resultSet) {
        BookUpgrade object = new BookUpgrade();
        object.setRowId(resultSet.getLong(0));
        object.setId(resultSet.isColumnNull(1) ? null : resultSet.getInt(1));
        object.setName(resultSet.getString(2));
        object.setUserId(resultSet.getInt(3));
        object.setAddColumn12(resultSet.getInt(4));
        return object;
    }

    @Override
    public void setPrimaryKeyValue(BookUpgrade object, long value) {
        object.setId((int)value);
    }

    @Override
    public String getTableName() {
        return "BookUpgrade";
    }

    @Override
    public String getInsertStatement() {
        return INSERT_STATEMENT;
    }

    @Override
    public String getUpdateStatement() {
        return UPDATE_STATEMENT;
    }

    @Override
    public String getDeleteStatement() {
        return DELETE_STATEMENT;
    }

    public OrmPredicates generatePredicatesGetRelated(String foreignKeyName,
            List<BookUpgrade> objects) {
        if (foreignKeyName == null || objects == null || objects.size() == 0) {
            return null;
        }
        try {
            switch(foreignKeyName) {
                case "BookUser": {
                    OrmPredicates predicates = new OrmPredicates(UserUpgrade.class);
                    int size = objects.size();
                    predicates.beginWrap();
                    for (int i = 0; i < size; i++) {
                        predicates.beginWrap();
                        predicates.equalTo("userId", objects.get(i).getUserId());
                        predicates.endWrap();
                        if (i < (size - 1)) {
                            predicates.or();
                        }
                    }
                    predicates.endWrap();
                    return predicates;
                }
                default: {
                    return null;
                }
            }
        } catch (IllegalPredicateException e) {
            return null;
        }
    }
}
