package com.bytetrack.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytetrack.data.model.ActivityLevel;
import com.bytetrack.data.model.UserProfile;
import java.lang.Class;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class UserProfileDao_Impl implements UserProfileDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserProfile> __insertionAdapterOfUserProfile;

  private final EntityDeletionOrUpdateAdapter<UserProfile> __updateAdapterOfUserProfile;

  private final SharedSQLiteStatement __preparedStmtOfUpdateTheme;

  private final SharedSQLiteStatement __preparedStmtOfUpdatePremiumStatus;

  public UserProfileDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserProfile = new EntityInsertionAdapter<UserProfile>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `user_profile` (`id`,`name`,`age`,`gender`,`height`,`weight`,`activityLevel`,`dailyCalorieGoal`,`dailyProteinGoal`,`dailyCarbsGoal`,`dailyFatGoal`,`dailyWaterGoal`,`isPremium`,`theme`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserProfile entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        statement.bindLong(3, entity.getAge());
        if (entity.getGender() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getGender());
        }
        statement.bindDouble(5, entity.getHeight());
        statement.bindDouble(6, entity.getWeight());
        statement.bindString(7, __ActivityLevel_enumToString(entity.getActivityLevel()));
        statement.bindLong(8, entity.getDailyCalorieGoal());
        statement.bindLong(9, entity.getDailyProteinGoal());
        statement.bindLong(10, entity.getDailyCarbsGoal());
        statement.bindLong(11, entity.getDailyFatGoal());
        statement.bindLong(12, entity.getDailyWaterGoal());
        final int _tmp = entity.isPremium() ? 1 : 0;
        statement.bindLong(13, _tmp);
        if (entity.getTheme() == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.getTheme());
        }
      }
    };
    this.__updateAdapterOfUserProfile = new EntityDeletionOrUpdateAdapter<UserProfile>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `user_profile` SET `id` = ?,`name` = ?,`age` = ?,`gender` = ?,`height` = ?,`weight` = ?,`activityLevel` = ?,`dailyCalorieGoal` = ?,`dailyProteinGoal` = ?,`dailyCarbsGoal` = ?,`dailyFatGoal` = ?,`dailyWaterGoal` = ?,`isPremium` = ?,`theme` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserProfile entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        statement.bindLong(3, entity.getAge());
        if (entity.getGender() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getGender());
        }
        statement.bindDouble(5, entity.getHeight());
        statement.bindDouble(6, entity.getWeight());
        statement.bindString(7, __ActivityLevel_enumToString(entity.getActivityLevel()));
        statement.bindLong(8, entity.getDailyCalorieGoal());
        statement.bindLong(9, entity.getDailyProteinGoal());
        statement.bindLong(10, entity.getDailyCarbsGoal());
        statement.bindLong(11, entity.getDailyFatGoal());
        statement.bindLong(12, entity.getDailyWaterGoal());
        final int _tmp = entity.isPremium() ? 1 : 0;
        statement.bindLong(13, _tmp);
        if (entity.getTheme() == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.getTheme());
        }
        statement.bindLong(15, entity.getId());
      }
    };
    this.__preparedStmtOfUpdateTheme = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE user_profile SET theme = ? WHERE id = 1";
        return _query;
      }
    };
    this.__preparedStmtOfUpdatePremiumStatus = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE user_profile SET isPremium = ? WHERE id = 1";
        return _query;
      }
    };
  }

  @Override
  public Object insertUserProfile(final UserProfile userProfile,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUserProfile.insert(userProfile);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object updateUserProfile(final UserProfile userProfile,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfUserProfile.handle(userProfile);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object updateTheme(final String theme, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateTheme.acquire();
        int _argIndex = 1;
        if (theme == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, theme);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateTheme.release(_stmt);
        }
      }
    }, arg1);
  }

  @Override
  public Object updatePremiumStatus(final boolean isPremium,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdatePremiumStatus.acquire();
        int _argIndex = 1;
        final int _tmp = isPremium ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdatePremiumStatus.release(_stmt);
        }
      }
    }, arg1);
  }

  @Override
  public LiveData<UserProfile> getUserProfile() {
    final String _sql = "SELECT * FROM user_profile WHERE id = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"user_profile"}, false, new Callable<UserProfile>() {
      @Override
      @Nullable
      public UserProfile call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfHeight = CursorUtil.getColumnIndexOrThrow(_cursor, "height");
          final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "weight");
          final int _cursorIndexOfActivityLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "activityLevel");
          final int _cursorIndexOfDailyCalorieGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "dailyCalorieGoal");
          final int _cursorIndexOfDailyProteinGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "dailyProteinGoal");
          final int _cursorIndexOfDailyCarbsGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "dailyCarbsGoal");
          final int _cursorIndexOfDailyFatGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "dailyFatGoal");
          final int _cursorIndexOfDailyWaterGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "dailyWaterGoal");
          final int _cursorIndexOfIsPremium = CursorUtil.getColumnIndexOrThrow(_cursor, "isPremium");
          final int _cursorIndexOfTheme = CursorUtil.getColumnIndexOrThrow(_cursor, "theme");
          final UserProfile _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmpAge;
            _tmpAge = _cursor.getInt(_cursorIndexOfAge);
            final String _tmpGender;
            if (_cursor.isNull(_cursorIndexOfGender)) {
              _tmpGender = null;
            } else {
              _tmpGender = _cursor.getString(_cursorIndexOfGender);
            }
            final float _tmpHeight;
            _tmpHeight = _cursor.getFloat(_cursorIndexOfHeight);
            final float _tmpWeight;
            _tmpWeight = _cursor.getFloat(_cursorIndexOfWeight);
            final ActivityLevel _tmpActivityLevel;
            _tmpActivityLevel = __ActivityLevel_stringToEnum(_cursor.getString(_cursorIndexOfActivityLevel));
            final int _tmpDailyCalorieGoal;
            _tmpDailyCalorieGoal = _cursor.getInt(_cursorIndexOfDailyCalorieGoal);
            final int _tmpDailyProteinGoal;
            _tmpDailyProteinGoal = _cursor.getInt(_cursorIndexOfDailyProteinGoal);
            final int _tmpDailyCarbsGoal;
            _tmpDailyCarbsGoal = _cursor.getInt(_cursorIndexOfDailyCarbsGoal);
            final int _tmpDailyFatGoal;
            _tmpDailyFatGoal = _cursor.getInt(_cursorIndexOfDailyFatGoal);
            final int _tmpDailyWaterGoal;
            _tmpDailyWaterGoal = _cursor.getInt(_cursorIndexOfDailyWaterGoal);
            final boolean _tmpIsPremium;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsPremium);
            _tmpIsPremium = _tmp != 0;
            final String _tmpTheme;
            if (_cursor.isNull(_cursorIndexOfTheme)) {
              _tmpTheme = null;
            } else {
              _tmpTheme = _cursor.getString(_cursorIndexOfTheme);
            }
            _result = new UserProfile(_tmpId,_tmpName,_tmpAge,_tmpGender,_tmpHeight,_tmpWeight,_tmpActivityLevel,_tmpDailyCalorieGoal,_tmpDailyProteinGoal,_tmpDailyCarbsGoal,_tmpDailyFatGoal,_tmpDailyWaterGoal,_tmpIsPremium,_tmpTheme);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getUserProfileSync(final Continuation<? super UserProfile> arg0) {
    final String _sql = "SELECT * FROM user_profile WHERE id = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<UserProfile>() {
      @Override
      @Nullable
      public UserProfile call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfHeight = CursorUtil.getColumnIndexOrThrow(_cursor, "height");
          final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "weight");
          final int _cursorIndexOfActivityLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "activityLevel");
          final int _cursorIndexOfDailyCalorieGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "dailyCalorieGoal");
          final int _cursorIndexOfDailyProteinGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "dailyProteinGoal");
          final int _cursorIndexOfDailyCarbsGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "dailyCarbsGoal");
          final int _cursorIndexOfDailyFatGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "dailyFatGoal");
          final int _cursorIndexOfDailyWaterGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "dailyWaterGoal");
          final int _cursorIndexOfIsPremium = CursorUtil.getColumnIndexOrThrow(_cursor, "isPremium");
          final int _cursorIndexOfTheme = CursorUtil.getColumnIndexOrThrow(_cursor, "theme");
          final UserProfile _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmpAge;
            _tmpAge = _cursor.getInt(_cursorIndexOfAge);
            final String _tmpGender;
            if (_cursor.isNull(_cursorIndexOfGender)) {
              _tmpGender = null;
            } else {
              _tmpGender = _cursor.getString(_cursorIndexOfGender);
            }
            final float _tmpHeight;
            _tmpHeight = _cursor.getFloat(_cursorIndexOfHeight);
            final float _tmpWeight;
            _tmpWeight = _cursor.getFloat(_cursorIndexOfWeight);
            final ActivityLevel _tmpActivityLevel;
            _tmpActivityLevel = __ActivityLevel_stringToEnum(_cursor.getString(_cursorIndexOfActivityLevel));
            final int _tmpDailyCalorieGoal;
            _tmpDailyCalorieGoal = _cursor.getInt(_cursorIndexOfDailyCalorieGoal);
            final int _tmpDailyProteinGoal;
            _tmpDailyProteinGoal = _cursor.getInt(_cursorIndexOfDailyProteinGoal);
            final int _tmpDailyCarbsGoal;
            _tmpDailyCarbsGoal = _cursor.getInt(_cursorIndexOfDailyCarbsGoal);
            final int _tmpDailyFatGoal;
            _tmpDailyFatGoal = _cursor.getInt(_cursorIndexOfDailyFatGoal);
            final int _tmpDailyWaterGoal;
            _tmpDailyWaterGoal = _cursor.getInt(_cursorIndexOfDailyWaterGoal);
            final boolean _tmpIsPremium;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsPremium);
            _tmpIsPremium = _tmp != 0;
            final String _tmpTheme;
            if (_cursor.isNull(_cursorIndexOfTheme)) {
              _tmpTheme = null;
            } else {
              _tmpTheme = _cursor.getString(_cursorIndexOfTheme);
            }
            _result = new UserProfile(_tmpId,_tmpName,_tmpAge,_tmpGender,_tmpHeight,_tmpWeight,_tmpActivityLevel,_tmpDailyCalorieGoal,_tmpDailyProteinGoal,_tmpDailyCarbsGoal,_tmpDailyFatGoal,_tmpDailyWaterGoal,_tmpIsPremium,_tmpTheme);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, arg0);
  }

  @Override
  public LiveData<Integer> getDailyCalorieGoal() {
    final String _sql = "SELECT dailyCalorieGoal FROM user_profile WHERE id = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"user_profile"}, false, new Callable<Integer>() {
      @Override
      @Nullable
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            if (_cursor.isNull(0)) {
              _result = null;
            } else {
              _result = _cursor.getInt(0);
            }
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Integer> getDailyWaterGoal() {
    final String _sql = "SELECT dailyWaterGoal FROM user_profile WHERE id = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"user_profile"}, false, new Callable<Integer>() {
      @Override
      @Nullable
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            if (_cursor.isNull(0)) {
              _result = null;
            } else {
              _result = _cursor.getInt(0);
            }
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<String> getUserTheme() {
    final String _sql = "SELECT theme FROM user_profile WHERE id = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"user_profile"}, false, new Callable<String>() {
      @Override
      @Nullable
      public String call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final String _result;
          if (_cursor.moveToFirst()) {
            if (_cursor.isNull(0)) {
              _result = null;
            } else {
              _result = _cursor.getString(0);
            }
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private String __ActivityLevel_enumToString(@NonNull final ActivityLevel _value) {
    switch (_value) {
      case SEDENTARY: return "SEDENTARY";
      case LIGHT: return "LIGHT";
      case MODERATE: return "MODERATE";
      case ACTIVE: return "ACTIVE";
      case VERY_ACTIVE: return "VERY_ACTIVE";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private ActivityLevel __ActivityLevel_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "SEDENTARY": return ActivityLevel.SEDENTARY;
      case "LIGHT": return ActivityLevel.LIGHT;
      case "MODERATE": return ActivityLevel.MODERATE;
      case "ACTIVE": return ActivityLevel.ACTIVE;
      case "VERY_ACTIVE": return ActivityLevel.VERY_ACTIVE;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }
}
