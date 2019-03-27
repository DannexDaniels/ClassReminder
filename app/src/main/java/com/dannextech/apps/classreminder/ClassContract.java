package com.dannextech.apps.classreminder;

import android.provider.BaseColumns;

public class ClassContract {
    //To prevent someone from accidentally instanstiating this class we make the contructor private
    private ClassContract(){}

    //inner class defines the table contents
    public static class Classes implements BaseColumns {
        public static final String TABLE_NAME = "services";
        public static final String COL_CLASS_NAME = "name";
        public static final String COL_CLASS_CODE = "price";
        public static final String COL_CLASS_REMINDER = "reminder";
        public static final String COL_CLASS_DATE = "date";
        public static final String COL_CLASS_VENUE = "venue";
        public static final String COL_CLASS_TIME = "time";
    }
}
