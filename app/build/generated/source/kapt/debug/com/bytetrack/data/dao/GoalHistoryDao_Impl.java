package com.bytetrack.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytetrack.data.model.GoalHistory;
import com.bytetrack.utils.Converters;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class GoalHistoryDao_Impl implements GoalHistoryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<GoalHistory> __insertionAdapterOfGoalHistory;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<GoalHistory> __updateAdapterOfGoalHistory;

  public GoalHistoryDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGoalHistory = new EntityInsertionAdapter<GoalHistory>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `goal_history` (`id`,`goalType`,`previousValue`,`newValue`,`date`,`achieved`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final GoalHistory entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getGoalType() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getGoalType());
        }
        statement.bindLong(3, entity.getPreviousValue());
        statement.bindLong(4, entity.getNewValue());
        final Long _tmp = __converters.dateToTimestamp(entity.getDate());
        if (_tmp == null) {
          statement.bindNull(5);
        } else {
          statement.bindLong(5, _tmp);
        }
        final int _tmp_1 = entity.getAchieved() ? 1 : 0;
        statement.bindLong(6, _tmp_1);
      }
    };
    this.__updateAdapterOfGoalHistory = new EntityDeletionOrUpdateAdapter<GoalHistory>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `goal_history` SET `id` = ?,`goalType` = ?,`previousValue` = ?,`newValue` = ?,`date` = ?,`achieved` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final GoalHistory entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getGoalType() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getGoalType());
        }
        statement.bindLong(3, entity.getPreviousValue());
        statement.bindLong(4, entity.getNewValue());
        final Long _tmp = __converters.dateToTimestamp(entity.getDate());
        if (_tmp == null) {
          statement.bindNull(5);
        } else {
          statement.bindLong(5, _tmp);
        }
        final int _tmp_1 = entity.getAchieved() ? 1 : 0;
        statement.bindLong(6, _tmp_1);
        statement.bindLong(7, entity.getId());
      }
    };
  }

  @Override
  public Object insertGoalHistory(final GoalHistory goalHistory,
      final Continuation<? super Long> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfGoalHistory.insertAndReturnId(goalHistory);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object updateGoalHistory(final GoalHistory goalHistory,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfGoalHistory.handle(goalHistory);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object getAllGoalHistory(final Continuation<? super List<GoalHistory>> arg0) {
    final String _sql = "SELECT * FROM goal_history ORDER BY date DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<GoalHistory>>() {
      @Override
      @NonNull
      public List<GoalHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfGoalType = CursorUtil.getColumnIndexOrThrow(_cursor, "goalType");
          final int _cursorIndexOfPreviousValue = CursorUtil.getColumnIndexOrThrow(_cursor, "previousValue");
          final int _cursorIndexOfNewValue = CursorUtil.getColumnIndexOrThrow(_cursor, "newValue");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfAchieved = CursorUtil.getColumnIndexOrThrow(_cursor, "achieved");
          final List<GoalHistory> _result = new ArrayList<GoalHistory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final GoalHistory _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpGoalType;
            if (_cursor.isNull(_cursorIndexOfGoalType)) {
              _tmpGoalType = null;
            } else {
              _tmpGoalType = _cursor.getString(_cursorIndexOfGoalType);
            }
            final int _tmpPreviousValue;
            _tmpPreviousValue = _cursor.getInt(_cursorIndexOfPreviousValue);
            final int _tmpNewValue;
            _tmpNewValue = _cursor.getInt(_cursorIndexOfNewValue);
            final Date _tmpDate;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = __converters.fromTimestamp(_tmp);
            final boolean _tmpAchieved;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfAchieved);
            _tmpAchieved = _tmp_1 != 0;
            _item = new GoalHistory(_tmpId,_tmpGoalType,_tmpPreviousValue,_tmpNewValue,_tmpDate,_tmpAchieved);
            _result.add(_item);
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
  public Object getGoalHistoryByType(final String goalType,
      final Continuation<? super List<GoalHistory>> arg1) {
    final String _sql = "SELECT * FROM goal_history WHERE goalType = ? ORDER BY date DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (goalType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, goalType);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<GoalHistory>>() {
      @Override
      @NonNull
      public List<GoalHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfGoalType = CursorUtil.getColumnIndexOrThrow(_cursor, "goalType");
          final int _cursorIndexOfPreviousValue = CursorUtil.getColumnIndexOrThrow(_cursor, "previousValue");
          final int _cursorIndexOfNewValue = CursorUtil.getColumnIndexOrThrow(_cursor, "newValue");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfAchieved = CursorUtil.getColumnIndexOrThrow(_cursor, "achieved");
          final List<GoalHistory> _result = new ArrayList<GoalHistory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final GoalHistory _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpGoalType;
            if (_cursor.isNull(_cursorIndexOfGoalType)) {
              _tmpGoalType = null;
            } else {
              _tmpGoalType = _cursor.getString(_cursorIndexOfGoalType);
            }
            final int _tmpPreviousValue;
            _tmpPreviousValue = _cursor.getInt(_cursorIndexOfPreviousValue);
            final int _tmpNewValue;
            _tmpNewValue = _cursor.getInt(_cursorIndexOfNewValue);
            final Date _tmpDate;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = __converters.fromTimestamp(_tmp);
            final boolean _tmpAchieved;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfAchieved);
            _tmpAchieved = _tmp_1 != 0;
            _item = new GoalHistory(_tmpId,_tmpGoalType,_tmpPreviousValue,_tmpNewValue,_tmpDate,_tmpAchieved);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, arg1);
  }

  @Override
  public Object getGoalHistoryBetweenDates(final Date startDate, final Date endDate,
      final Continuation<? super List<GoalHistory>> arg2) {
    final String _sql = "SELECT * FROM goal_history WHERE date BETWEEN ? AND ? ORDER BY date DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    final Long _tmp = __converters.dateToTimestamp(startDate);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp);
    }
    _argIndex = 2;
    final Long _tmp_1 = __converters.dateToTimestamp(endDate);
    if (_tmp_1 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp_1);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<GoalHistory>>() {
      @Override
      @NonNull
      public List<GoalHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfGoalType = CursorUtil.getColumnIndexOrThrow(_cursor, "goalType");
          final int _cursorIndexOfPreviousValue = CursorUtil.getColumnIndexOrThrow(_cursor, "previousValue");
          final int _cursorIndexOfNewValue = CursorUtil.getColumnIndexOrThrow(_cursor, "newValue");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfAchieved = CursorUtil.getColumnIndexOrThrow(_cursor, "achieved");
          final List<GoalHistory> _result = new ArrayList<GoalHistory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final GoalHistory _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpGoalType;
            if (_cursor.isNull(_cursorIndexOfGoalType)) {
              _tmpGoalType = null;
            } else {
              _tmpGoalType = _cursor.getString(_cursorIndexOfGoalType);
            }
            final int _tmpPreviousValue;
            _tmpPreviousValue = _cursor.getInt(_cursorIndexOfPreviousValue);
            final int _tmpNewValue;
            _tmpNewValue = _cursor.getInt(_cursorIndexOfNewValue);
            final Date _tmpDate;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = __converters.fromTimestamp(_tmp_2);
            final boolean _tmpAchieved;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfAchieved);
            _tmpAchieved = _tmp_3 != 0;
            _item = new GoalHistory(_tmpId,_tmpGoalType,_tmpPreviousValue,_tmpNewValue,_tmpDate,_tmpAchieved);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, arg2);
  }

  @Override
  public Object getAchievedGoals(final Continuation<? super List<GoalHistory>> arg0) {
    final String _sql = "SELECT * FROM goal_history WHERE achieved = 1 ORDER BY date DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<GoalHistory>>() {
      @Override
      @NonNull
      public List<GoalHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfGoalType = CursorUtil.getColumnIndexOrThrow(_cursor, "goalType");
          final int _cursorIndexOfPreviousValue = CursorUtil.getColumnIndexOrThrow(_cursor, "previousValue");
          final int _cursorIndexOfNewValue = CursorUtil.getColumnIndexOrThrow(_cursor, "newValue");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfAchieved = CursorUtil.getColumnIndexOrThrow(_cursor, "achieved");
          final List<GoalHistory> _result = new ArrayList<GoalHistory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final GoalHistory _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpGoalType;
            if (_cursor.isNull(_cursorIndexOfGoalType)) {
              _tmpGoalType = null;
            } else {
              _tmpGoalType = _cursor.getString(_cursorIndexOfGoalType);
            }
            final int _tmpPreviousValue;
            _tmpPreviousValue = _cursor.getInt(_cursorIndexOfPreviousValue);
            final int _tmpNewValue;
            _tmpNewValue = _cursor.getInt(_cursorIndexOfNewValue);
            final Date _tmpDate;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = __converters.fromTimestamp(_tmp);
            final boolean _tmpAchieved;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfAchieved);
            _tmpAchieved = _tmp_1 != 0;
            _item = new GoalHistory(_tmpId,_tmpGoalType,_tmpPreviousValue,_tmpNewValue,_tmpDate,_tmpAchieved);
            _result.add(_item);
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
  public Object getAchievedGoalsCount(final Continuation<? super Integer> arg0) {
    final String _sql = "SELECT COUNT(*) FROM goal_history WHERE achieved = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
