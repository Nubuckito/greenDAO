package de.greenrobot.daotest;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoConfig;
import de.greenrobot.dao.IdentityScope;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.Query;
import de.greenrobot.dao.QueryBuilder;

import de.greenrobot.daotest.ToManyTargetEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table TO_MANY_TARGET_ENTITY (schema version 1).
*/
public class ToManyTargetEntityDao extends AbstractDao<ToManyTargetEntity, Long> {

    public static final String TABLENAME = "TO_MANY_TARGET_ENTITY";

    public static class Properties {
        public final static Property ToManyId = new Property(0, Long.class, "toManyId", false, "TO_MANY_ID");
        public final static Property ToManyIdDesc = new Property(1, Long.class, "toManyIdDesc", false, "TO_MANY_ID_DESC");
        public final static Property Id = new Property(2, Long.class, "id", true, "_id");
    };

    private Query toManyEntity_ToManyTargetEntityQuery;
    private Query toManyEntity_ToManyDescListQuery;

    public ToManyTargetEntityDao(DaoConfig config) {
        super(config);
    }
    
    public ToManyTargetEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String sql = "CREATE TABLE " + (ifNotExists? "IF NOT EXISTS ": "") + "'TO_MANY_TARGET_ENTITY' (" + //
                "'TO_MANY_ID' INTEGER," + // 0: toManyId
                "'TO_MANY_ID_DESC' INTEGER," + // 1: toManyIdDesc
                "'_id' INTEGER PRIMARY KEY );"; // 2: id
        db.execSQL(sql);
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'TO_MANY_TARGET_ENTITY'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ToManyTargetEntity entity) {
        stmt.clearBindings();
 
        Long toManyId = entity.getToManyId();
        if (toManyId != null) {
            stmt.bindLong(1, toManyId);
        }
 
        Long toManyIdDesc = entity.getToManyIdDesc();
        if (toManyIdDesc != null) {
            stmt.bindLong(2, toManyIdDesc);
        }
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(3, id);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2);
    }    

    /** @inheritdoc */
    @Override
    public ToManyTargetEntity readEntity(Cursor cursor, int offset) {
        ToManyTargetEntity entity = new ToManyTargetEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // toManyId
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // toManyIdDesc
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2) // id
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ToManyTargetEntity entity, int offset) {
        entity.setToManyId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setToManyIdDesc(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
     }
    
    @Override
    protected Long updateKeyAfterInsert(ToManyTargetEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(ToManyTargetEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "toManyTargetEntity" to-many relationship of ToManyEntity. */
    @SuppressWarnings("unchecked")
    public synchronized List<ToManyTargetEntity> _queryToManyEntity_ToManyTargetEntity(Long toManyId) {
        if (toManyEntity_ToManyTargetEntityQuery == null) {
            QueryBuilder<ToManyTargetEntity> queryBuilder = queryBuilder();
            queryBuilder.where(Properties.ToManyId.eq(toManyId));
            queryBuilder.orderRaw("_id ASC");
            toManyEntity_ToManyTargetEntityQuery = queryBuilder.build();
        } else {
            toManyEntity_ToManyTargetEntityQuery.setParameter(0, toManyId);
        }
        return toManyEntity_ToManyTargetEntityQuery.list();
    }

    /** Internal query to resolve the "ToManyDescList" to-many relationship of ToManyEntity. */
    @SuppressWarnings("unchecked")
    public synchronized List<ToManyTargetEntity> _queryToManyEntity_ToManyDescList(Long toManyIdDesc) {
        if (toManyEntity_ToManyDescListQuery == null) {
            QueryBuilder<ToManyTargetEntity> queryBuilder = queryBuilder();
            queryBuilder.where(Properties.ToManyIdDesc.eq(toManyIdDesc));
            queryBuilder.orderRaw("_id DESC");
            toManyEntity_ToManyDescListQuery = queryBuilder.build();
        } else {
            toManyEntity_ToManyDescListQuery.setParameter(0, toManyIdDesc);
        }
        return toManyEntity_ToManyDescListQuery.list();
    }

}