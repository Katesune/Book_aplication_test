package com.example.bookapplication;

        import android.app.Activity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.LinearLayout;
        import android.widget.TextView;

public class PageActivity extends Activity {

    String bg_state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

        final Button large_text = (Button)findViewById(R.id.large_text);
        final Button small_text = (Button)findViewById(R.id.small_text);
        final TextView textbook = (TextView)findViewById(R.id.textbook);

        int page_number = getIntent().getIntExtra("page_number", 0);
        bg_state = "day";
    }

    public void changeLargeText(View v){
        final TextView textbook = (TextView)findViewById(R.id.textbook);
        float size = textbook.getTextSize();
        size = ConvertPXtoSP(size);
        textbook.setTextSize(size+3);
    }

    public void changeSmallText(View v){
        final TextView textbook = (TextView)findViewById(R.id.textbook);
        float size = textbook.getTextSize();
        size = ConvertPXtoSP(size);
        textbook.setTextSize(size-3);
    }


    public int ConvertPXtoSP(float dp){
        float scale = getResources().getDisplayMetrics().density;
        return((int) (dp/scale));
    }

    public void changeBack(View v){
        int bg_bg;
        int bg_txt;

        switch (bg_state) {
            case "day":
                bg_state = "night";
                bg_bg = getResources().getColor(R.color.day_bg);
                bg_txt = getResources().getColor(R.color.day_txt);
                break;
            default:
                bg_state = "day";
                bg_bg = getResources().getColor(R.color.night_bg);
                bg_txt = getResources().getColor(R.color.night_txt);
                break;
        }

        setColors(bg_bg, bg_txt);
    }

    public void setColors(int bg_bg, int bg_txt){
        final LinearLayout bg = (LinearLayout) findViewById(R.id.container);
        final TextView textbook = (TextView)findViewById(R.id.textbook);
textbook.setText(bg_state);
        bg.setBackgroundColor(bg_bg);
        textbook.setBackgroundColor(bg_bg);
        textbook.setTextColor(bg_txt);
    }
}