package com.bonade.xxp.xqc_android_im.DB.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.bonade.xxp.xqc_android_im.DB.entity.UserEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "UserInfo".
*/
public class UserDao extends AbstractDao<UserEntity, Long> {

    public static final String TABLENAME = "UserInfo";

    /**
     * Properties of entity UserEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Cid = new Property(0, Long.class, "cid", true, "CID");
        public final static Property PeerId = new Property(1, int.class, "peerId", false, "PEER_ID");
        public final static Property MainName = new Property(2, String.class, "mainName", false, "MAIN_NAME");
        public final static Property Avatar = new Property(3, String.class, "avatar", false, "AVATAR");
        public final static Property CompanyId = new Property(4, Integer.class, "companyId", false, "COMPANY_ID");
        public final static Property CompanyName = new Property(5, String.class, "companyName", false, "COMPANY_NAME");
        public final static Property JobName = new Property(6, String.class, "jobName", false, "JOB_NAME");
        public final static Property DeptName = new Property(7, String.class, "deptName", false, "DEPT_NAME");
        public final static Property Mobile = new Property(8, String.class, "mobile", false, "MOBILE");
        public final static Property IsFriend = new Property(9, Integer.class, "isFriend", false, "IS_FRIEND");
        public final static Property Email = new Property(10, String.class, "email", false, "EMAIL");
        public final static Property UserName = new Property(11, String.class, "userName", false, "USER_NAME");
        public final static Property Status = new Property(12, Integer.class, "status", false, "STATUS");
        public final static Property Created = new Property(13, Integer.class, "created", false, "CREATED");
        public final static Property Updated = new Property(14, Integer.class, "updated", false, "UPDATED");
    }


    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"UserInfo\" (" + //
                "\"CID\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: cid
                "\"PEER_ID\" INTEGER NOT NULL UNIQUE ," + // 1: peerId
                "\"MAIN_NAME\" TEXT," + // 2: mainName
                "\"AVATAR\" TEXT," + // 3: avatar
                "\"COMPANY_ID\" INTEGER," + // 4: companyId
                "\"COMPANY_NAME\" TEXT," + // 5: companyName
                "\"JOB_NAME\" TEXT," + // 6: jobName
                "\"DEPT_NAME\" TEXT," + // 7: deptName
                "\"MOBILE\" TEXT," + // 8: mobile
                "\"IS_FRIEND\" INTEGER," + // 9: isFriend
                "\"EMAIL\" TEXT," + // 10: email
                "\"USER_NAME\" TEXT," + // 11: userName
                "\"STATUS\" INTEGER," + // 12: status
                "\"CREATED\" INTEGER," + // 13: created
                "\"UPDATED\" INTEGER);"); // 14: updated
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_UserInfo_PEER_ID ON \"UserInfo\"" +
                " (\"PEER_ID\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"UserInfo\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, UserEntity entity) {
        stmt.clearBindings();
 
        Long cid = entity.getCid();
        if (cid != null) {
            stmt.bindLong(1, cid);
        }
        stmt.bindLong(2, entity.getPeerId());
 
        String mainName = entity.getMainName();
        if (mainName != null) {
            stmt.bindString(3, mainName);
        }
 
        String avatar = entity.getAvatar();
        if (avatar != null) {
            stmt.bindString(4, avatar);
        }
 
        Integer companyId = entity.getCompanyId();
        if (companyId != null) {
            stmt.bindLong(5, companyId);
        }
 
        String companyName = entity.getCompanyName();
        if (companyName != null) {
            stmt.bindString(6, companyName);
        }
 
        String jobName = entity.getJobName();
        if (jobName != null) {
            stmt.bindString(7, jobName);
        }
 
        String deptName = entity.getDeptName();
        if (deptName != null) {
            stmt.bindString(8, deptName);
        }
 
        String mobile = entity.getMobile();
        if (mobile != null) {
            stmt.bindString(9, mobile);
        }
 
        Integer isFriend = entity.getIsFriend();
        if (isFriend != null) {
            stmt.bindLong(10, isFriend);
        }
 
        String email = entity.getEmail();
        if (email != null) {
            stmt.bindString(11, email);
        }
 
        String userName = entity.getUserName();
        if (userName != null) {
            stmt.bindString(12, userName);
        }
 
        Integer status = entity.getStatus();
        if (status != null) {
            stmt.bindLong(13, status);
        }
 
        Integer created = entity.getCreated();
        if (created != null) {
            stmt.bindLong(14, created);
        }
 
        Integer updated = entity.getUpdated();
        if (updated != null) {
            stmt.bindLong(15, updated);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, UserEntity entity) {
        stmt.clearBindings();
 
        Long cid = entity.getCid();
        if (cid != null) {
            stmt.bindLong(1, cid);
        }
        stmt.bindLong(2, entity.getPeerId());
 
        String mainName = entity.getMainName();
        if (mainName != null) {
            stmt.bindString(3, mainName);
        }
 
        String avatar = entity.getAvatar();
        if (avatar != null) {
            stmt.bindString(4, avatar);
        }
 
        Integer companyId = entity.getCompanyId();
        if (companyId != null) {
            stmt.bindLong(5, companyId);
        }
 
        String companyName = entity.getCompanyName();
        if (companyName != null) {
            stmt.bindString(6, companyName);
        }
 
        String jobName = entity.getJobName();
        if (jobName != null) {
            stmt.bindString(7, jobName);
        }
 
        String deptName = entity.getDeptName();
        if (deptName != null) {
            stmt.bindString(8, deptName);
        }
 
        String mobile = entity.getMobile();
        if (mobile != null) {
            stmt.bindString(9, mobile);
        }
 
        Integer isFriend = entity.getIsFriend();
        if (isFriend != null) {
            stmt.bindLong(10, isFriend);
        }
 
        String email = entity.getEmail();
        if (email != null) {
            stmt.bindString(11, email);
        }
 
        String userName = entity.getUserName();
        if (userName != null) {
            stmt.bindString(12, userName);
        }
 
        Integer status = entity.getStatus();
        if (status != null) {
            stmt.bindLong(13, status);
        }
 
        Integer created = entity.getCreated();
        if (created != null) {
            stmt.bindLong(14, created);
        }
 
        Integer updated = entity.getUpdated();
        if (updated != null) {
            stmt.bindLong(15, updated);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public UserEntity readEntity(Cursor cursor, int offset) {
        UserEntity entity = new UserEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // cid
            cursor.getInt(offset + 1), // peerId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // mainName
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // avatar
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // companyId
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // companyName
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // jobName
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // deptName
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // mobile
            cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9), // isFriend
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // email
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // userName
            cursor.isNull(offset + 12) ? null : cursor.getInt(offset + 12), // status
            cursor.isNull(offset + 13) ? null : cursor.getInt(offset + 13), // created
            cursor.isNull(offset + 14) ? null : cursor.getInt(offset + 14) // updated
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, UserEntity entity, int offset) {
        entity.setCid(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPeerId(cursor.getInt(offset + 1));
        entity.setMainName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setAvatar(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setCompanyId(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setCompanyName(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setJobName(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setDeptName(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setMobile(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setIsFriend(cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9));
        entity.setEmail(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setUserName(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setStatus(cursor.isNull(offset + 12) ? null : cursor.getInt(offset + 12));
        entity.setCreated(cursor.isNull(offset + 13) ? null : cursor.getInt(offset + 13));
        entity.setUpdated(cursor.isNull(offset + 14) ? null : cursor.getInt(offset + 14));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(UserEntity entity, long rowId) {
        entity.setCid(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(UserEntity entity) {
        if(entity != null) {
            return entity.getCid();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(UserEntity entity) {
        return entity.getCid() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
