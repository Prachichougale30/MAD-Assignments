<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#F5F5F5">

    <TextView
        android:id="@+id/title"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/login_page"
        android:textSize="28sp"
        android:textStyle="bold"
        android:textColor="#333333"
        app:layout_constraintBottom_toTopOf="@id/username"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_chainStyle="packed"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginBottom="30dp"/>


    <EditText
        android:id="@+id/username"
        android:layout_width="280dp"
        android:layout_height="wrap_content"
        android:hint="@string/enter_username"
        android:padding="12dp"
        android:background="@android:drawable/edit_text"
        android:inputType="textPersonName"
        android:autofillHints="username"
        android:textColor="@color/black"
        app:layout_constraintTop_toBottomOf="@id/title"
        app:layout_constraintBottom_toTopOf="@id/password"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginBottom="20dp"/>


    <EditText
        android:id="@+id/password"
        android:layout_width="280dp"
        android:layout_height="wrap_content"
        android:hint="@string/enter_password"
        android:padding="12dp"
        android:inputType="textPassword"
        android:autofillHints="password"
         android:textColor="@color/black"
        app:layout_constraintTop_toBottomOf="@id/username"
        app:layout_constraintBottom_toTopOf="@id/loginBtn"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginBottom="25dp"/>


    <Button
        android:id="@+id/loginBtn"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:text="@string/login1"
        android:textStyle="bold"
        android:backgroundTint="#3F51B5"
        android:textColor="#FFFFFF"
        android:padding="10dp"
        app:layout_constraintTop_toBottomOf="@id/password"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"/>

</androidx.constraintlayout.widget.ConstraintLayout>
