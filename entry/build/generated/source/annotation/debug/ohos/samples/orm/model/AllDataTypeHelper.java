// Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
package ohos.samples.orm.model;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import ohos.data.orm.EntityHelper;
import ohos.data.orm.OrmPredicates;
import ohos.data.rdb.Statement;
import ohos.data.resultset.ResultSet;

/**
 * Generated by ohos.data.orm.processor for AllDataType in ohos.samples.orm.model.BookStore. Do not modify!
 *
 * @author Huawei
 * @since 2021-07-20
 */
public class AllDataTypeHelper implements EntityHelper<AllDataType> {
    private static final AllDataTypeHelper INSTANCE = new AllDataTypeHelper();

    private static final String INSERT_STATEMENT = "INSERT INTO `AllDataType` (`id`, `integerValue`, `longValue`, `shortValue`, `booleanValue`, `doubleValue`, `floatValue`, `stringValue`, `blobValue`, `clobValue`, `byteValue`, `dateValue`, `timeValue`, `timestampValue`, `calendarValue`, `characterValue`, `primIntValue`, `primLongValue`, `primShortValue`, `primFloatValue`, `primDoubleValue`, `primBooleanValue`, `primByteValue`, `primCharValue`, `order`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String UPDATE_STATEMENT = "UPDATE `AllDataType` Set `id` = ?, `integerValue` = ?, `longValue` = ?, `shortValue` = ?, `booleanValue` = ?, `doubleValue` = ?, `floatValue` = ?, `stringValue` = ?, `blobValue` = ?, `clobValue` = ?, `byteValue` = ?, `dateValue` = ?, `timeValue` = ?, `timestampValue` = ?, `calendarValue` = ?, `characterValue` = ?, `primIntValue` = ?, `primLongValue` = ?, `primShortValue` = ?, `primFloatValue` = ?, `primDoubleValue` = ?, `primBooleanValue` = ?, `primByteValue` = ?, `primCharValue` = ?, `order` = ? WHERE `rowid` = ?";

    private static final String DELETE_STATEMENT = "DELETE FROM `AllDataType` WHERE `rowid` = ?";

    private AllDataTypeHelper() {
    }

    public static AllDataTypeHelper getInstance() {
        return INSTANCE;
    }

    @Override
    public void bindValue(Statement statement, AllDataType object) {
        statement.setLong(1, object.getId());
        Integer integerValue = object.getIntegerValue();
        if (integerValue != null) {
            statement.setLong(2, integerValue);
        } else {
            statement.setNull(2);
        }
        Long longValue = object.getLongValue();
        if (longValue != null) {
            statement.setLong(3, longValue);
        } else {
            statement.setNull(3);
        }
        Short shortValue = object.getShortValue();
        if (shortValue != null) {
            statement.setLong(4, shortValue);
        } else {
            statement.setNull(4);
        }
        Boolean booleanValue = object.getBooleanValue();
        if (booleanValue != null) {
            statement.setLong(5, booleanValue ? (byte)1 : (byte)0);
        } else {
            statement.setNull(5);
        }
        Double doubleValue = object.getDoubleValue();
        if (doubleValue != null) {
            statement.setDouble(6, doubleValue);
        } else {
            statement.setNull(6);
        }
        Float floatValue = object.getFloatValue();
        if (floatValue != null) {
            statement.setString(7, Float.toString(floatValue));
        } else {
            statement.setNull(7);
        }
        String stringValue = object.getStringValue();
        if (stringValue != null) {
            statement.setString(8, stringValue);
        } else {
            statement.setNull(8);
        }
        Blob blobValue = object.getBlobValue();
        if (blobValue != null) {
            statement.setBlob(9, ohos.data.orm.BindUtils.bindBlob(blobValue));
        } else {
            statement.setNull(9);
        }
        Clob clobValue = object.getClobValue();
        if (clobValue != null) {
            statement.setString(10, ohos.data.orm.BindUtils.clobToString(clobValue));
        } else {
            statement.setNull(10);
        }
        Byte byteValue = object.getByteValue();
        if (byteValue != null) {
            statement.setLong(11, byteValue);
        } else {
            statement.setNull(11);
        }
        Date dateValue = object.getDateValue();
        if (dateValue != null) {
            statement.setLong(12, dateValue.getTime());
        } else {
            statement.setNull(12);
        }
        Time timeValue = object.getTimeValue();
        if (timeValue != null) {
            statement.setLong(13, timeValue.getTime());
        } else {
            statement.setNull(13);
        }
        Timestamp timestampValue = object.getTimestampValue();
        if (timestampValue != null) {
            statement.setLong(14, timestampValue.getTime());
        } else {
            statement.setNull(14);
        }
        Calendar calendarValue = object.getCalendarValue();
        if (calendarValue != null) {
            statement.setLong(15, calendarValue.getTimeInMillis());
        } else {
            statement.setNull(15);
        }
        Character characterValue = object.getCharacterValue();
        if (characterValue != null) {
            statement.setString(16, String.valueOf(characterValue));
        } else {
            statement.setNull(16);
        }
        statement.setLong(17, object.getPrimIntValue());
        statement.setLong(18, object.getPrimLongValue());
        statement.setLong(19, object.getPrimShortValue());
        statement.setString(20, Float.toString(object.getPrimFloatValue()));
        statement.setDouble(21, object.getPrimDoubleValue());
        statement.setLong(22, object.isPrimBooleanValue() ? (byte)1 : (byte)0);
        statement.setLong(23, object.getPrimByteValue());
        statement.setString(24, String.valueOf(object.getPrimCharValue()));
        Integer order = object.getOrder();
        if (order != null) {
            statement.setLong(25, order);
        } else {
            statement.setNull(25);
        }
    }

    @Override
    public void bindValue(Statement statement, AllDataType object, long id) {
        this.bindValue(statement, object);
        statement.setLong(26, id);
    }

    @Override
    public AllDataType createInstance(ResultSet resultSet) {
        AllDataType object = new AllDataType();
        object.setRowId(resultSet.getLong(0));
        object.setId(resultSet.getInt(1));
        object.setIntegerValue(resultSet.isColumnNull(2) ? null : resultSet.getInt(2));
        object.setLongValue(resultSet.isColumnNull(3) ? null : resultSet.getLong(3));
        object.setShortValue(resultSet.isColumnNull(4) ? null : resultSet.getShort(4));
        object.setBooleanValue(resultSet.isColumnNull(5) ? null : resultSet.getInt(5) != 0);
        object.setDoubleValue(resultSet.isColumnNull(6) ? null : resultSet.getDouble(6));
        object.setFloatValue(resultSet.isColumnNull(7) ? null : resultSet.getFloat(7));
        object.setStringValue(resultSet.getString(8));
        object.setBlobValue(resultSet.isColumnNull(9) ? null : new ohos.data.orm.Blob(resultSet.getBlob(9)));
        object.setClobValue(resultSet.isColumnNull(10) ? null : new ohos.data.orm.Clob(resultSet.getString(10)));
        object.setByteValue(resultSet.isColumnNull(11) ? null : (byte) resultSet.getLong(11));
        object.setDateValue(resultSet.isColumnNull(12) ? null : new java.util.Date(resultSet.getLong(12)));
        object.setTimeValue(resultSet.isColumnNull(13) ? null : new java.sql.Time(resultSet.getLong(13)));
        object.setTimestampValue(resultSet.isColumnNull(14) ? null : new java.sql.Timestamp(resultSet.getLong(14)));
        object.setCalendarValue(resultSet.isColumnNull(15) ? null : ohos.data.orm.BindUtils.getCalendar(resultSet.getLong(15)));
        object.setCharacterValue(resultSet.isColumnNull(16) ? null : resultSet.getString(16).charAt(0));
        object.setPrimIntValue(resultSet.getInt(17));
        object.setPrimLongValue(resultSet.getLong(18));
        object.setPrimShortValue(resultSet.getShort(19));
        object.setPrimFloatValue(resultSet.getFloat(20));
        object.setPrimDoubleValue(resultSet.getDouble(21));
        object.setPrimBooleanValue(resultSet.getInt(22) != 0);
        object.setPrimByteValue((byte) resultSet.getLong(23));
        object.setPrimCharValue(resultSet.getString(24).charAt(0));
        object.setOrder(resultSet.isColumnNull(25) ? null : resultSet.getInt(25));
        return object;
    }

    @Override
    public void setPrimaryKeyValue(AllDataType object, long value) {
        object.setId((int)value);
    }

    @Override
    public String getTableName() {
        return "AllDataType";
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
            List<AllDataType> objects) {
        return null;
    }
}
