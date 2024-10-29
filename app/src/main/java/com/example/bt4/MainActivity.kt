package com.example.bt4

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.CalendarView.OnDateChangeListener
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var edtId: EditText? = null
    private var edtName: EditText? = null
    private var edtEmail: EditText? = null
    private var edtPhone: EditText? = null
    private var radioGroupGender: RadioGroup? = null
    private var btnShowCalendar: Button? = null
    private var btnSubmit: Button? = null
    private var calendarView: CalendarView? = null
    private var spinnerWard: Spinner? = null
    private var spinnerDistrict: Spinner? = null
    private var spinnerCity: Spinner? = null
    private var chkSports: CheckBox? = null
    private var chkMovies: CheckBox? = null
    private var chkMusic: CheckBox? = null
    private var chkTerms: CheckBox? = null
    private var selectedDate = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ các View
        edtId = findViewById(R.id.edtId)
        edtName = findViewById(R.id.edtName)
        radioGroupGender = findViewById(R.id.radioGroupGender)
        edtEmail = findViewById(R.id.edtEmail)
        edtPhone = findViewById(R.id.edtPhone)
        btnShowCalendar = findViewById(R.id.btnShowCalendar)
        calendarView = findViewById(R.id.calendarView)
        spinnerWard = findViewById(R.id.spinnerWard)
        spinnerDistrict = findViewById(R.id.spinnerDistrict)
        spinnerCity = findViewById(R.id.spinnerCity)
        chkSports = findViewById(R.id.chkSports)
        chkMovies = findViewById(R.id.chkMovies)
        chkMusic = findViewById(R.id.chkMusic)
        chkTerms = findViewById(R.id.chkTerms)
        btnSubmit = findViewById(R.id.btnSubmit)

        // Hiện/Ẩn CalendarView
        btnShowCalendar!!.setOnClickListener(View.OnClickListener { view: View? ->
            if (calendarView!!.getVisibility() == View.GONE) {
                calendarView!!.setVisibility(View.VISIBLE)
            } else {
                calendarView!!.setVisibility(View.GONE)
            }
        })

        // Lưu lại ngày sinh khi chọn từ CalendarView
        calendarView!!.setOnDateChangeListener(OnDateChangeListener { view: CalendarView?, year: Int, month: Int, dayOfMonth: Int ->
            selectedDate = dayOfMonth.toString() + "/" + (month + 1) + "/" + year
        })

        // Xử lý khi nhấn nút Submit
        btnSubmit!!.setOnClickListener(View.OnClickListener { view: View? -> checkForm() })
    }

    private fun checkForm() {
        // Kiểm tra các trường thông tin
        if (edtId!!.text.toString().isEmpty()) {
            edtId!!.error = "Vui lòng nhập mã số"
            return
        }
        if (edtName!!.text.toString().isEmpty()) {
            edtName!!.error = "Vui lòng nhập họ tên"
            return
        }
        if (radioGroupGender!!.checkedRadioButtonId == -1) {
            Toast.makeText(this, "Vui lòng chọn giới tính", Toast.LENGTH_SHORT).show()
            return
        }
        if (edtEmail!!.text.toString().isEmpty()) {
            edtEmail!!.error = "Vui lòng nhập email"
            return
        }
        if (edtPhone!!.text.toString().isEmpty()) {
            edtPhone!!.error = "Vui lòng nhập số điện thoại"
            return
        }
        if (selectedDate.isEmpty()) {
            Toast.makeText(this, "Vui lòng chọn ngày sinh", Toast.LENGTH_SHORT).show()
            return
        }
        if (!chkTerms!!.isChecked) {
            Toast.makeText(this, "Vui lòng đồng ý với các điều khoản", Toast.LENGTH_SHORT).show()
            return
        }

        // Nếu tất cả hợp lệ
        Toast.makeText(this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show()
    }
}