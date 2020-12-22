package org.o7planning.total;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Homepage extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView rcvCatecvory;
    ArrayList<Category> arrayList;

    private RecyclerView rcvClothes;
    private Button recentBtn,nearbyBtn;
    private GridLayoutManager gridLayoutManager;

    int icons[] = {R.drawable.go,R.drawable.yangzi9,R.drawable.yangzi9,R.drawable.go};

    String iconsName[] = {"Chrome", "Google Drive", "Facebook", "Twitter"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        rcvCatecvory = findViewById(R.id.main_rcv);
        arrayList = new ArrayList<>();

        rcvCatecvory.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        rcvCatecvory.setItemAnimator(new DefaultItemAnimator());

        for (int i = 0; i < icons.length; i++) {
            Category itemModel = new Category();
            itemModel.setResourceId(icons[i]);
            itemModel.setTitle(iconsName[i]);

            //add in array list
            arrayList.add(itemModel);
        }

        CategoryAdapter adapter = new CategoryAdapter(getApplicationContext(), arrayList);
        rcvCatecvory.setAdapter(adapter);


        //Food

        recentBtn = findViewById(R.id.recent);
        nearbyBtn = findViewById(R.id.nearby);

        rcvClothes = findViewById(R.id.rcv_food);
        gridLayoutManager = new GridLayoutManager(this,2);
        rcvClothes.setLayoutManager(gridLayoutManager);

        ClothesAdapter clothesAdapter = new ClothesAdapter(getListFood());
        rcvClothes.setAdapter(clothesAdapter);

        recentBtn.setOnClickListener(this);
        nearbyBtn.setOnClickListener(this);
    }

    private List<Clothes> getListFood() {

        List<Clothes> list= new ArrayList<>();

        list.add(new Clothes(R.drawable.go,"Humberger gà","bánh ngon nhất thế giới", Clothes.TypeNearBy));
        list.add(new Clothes(R.drawable.go,"Humberger Trứng ","bánh ngon nhất thế giới", Clothes.TypeNearBy));
        list.add(new Clothes(R.drawable.go,"Humberger bò ","bánh ngon nhất thế giới", Clothes.TypeNearBy));
        list.add(new Clothes(R.drawable.go,"Humberger mì ","bánh ngon nhất thế giới", Clothes.TypeNearBy));
        list.add(new Clothes(R.drawable.yangzi9,"Phở Hà Nội ","Phở ngon nhất thế giới ", Clothes.TypeNearBy));
        list.add(new Clothes(R.drawable.yangzi9,"Phở Hà Nội ","Phở ngon nhất thế giới ", Clothes.TypeNearBy));
        list.add(new Clothes(R.drawable.yangzi9,"Phở Hà Nội ","Phở ngon nhất thế giới ", Clothes.TypeNearBy));
        list.add(new Clothes(R.drawable.yangzi9,"Phở Hà Nội ","Phở ngon nhất thế giới", Clothes.TypeNearBy));
        list.add(new Clothes(R.drawable.yangzi9,"Phở Hà Nội ","Phở ngon nhất thế giới ", Clothes.TypeNearBy));
        list.add(new Clothes(R.drawable.dongnien3,"Mì cay nhiều cấp độ ","Ngon tuyệt cú mèo", Clothes.TypeNearBy));
        list.add(new Clothes(R.drawable.dongnien3,"Mì cay nhiều cấp độ ","Ngon tuyệt cú mèo", Clothes.TypeNearBy));
        list.add(new Clothes(R.drawable.dongnien3,"Mì cay nhiều cấp độ ","Ngon tuyệt cú mèo ", Clothes.TypeNearBy));
        list.add(new Clothes(R.drawable.dongnien3,"Mì cay nhiều cấp độ ","Ngon tuyệt cú mèo ", Clothes.TypeNearBy));
        list.add(new Clothes(R.drawable.dongnien3,"Mì cay nhiều cấp độ ","Ngon tuyệt cú mèo", Clothes.TypeNearBy));
        list.add(new Clothes(R.drawable.dongnien3,"Mì cay nhiều cấp độ ","Ngon tuyệt cú mèo ", Clothes.TypeNearBy));
        list.add(new Clothes(R.drawable.dongnien3,"Mì cay nhiều cấp độ ","Ngon tuyệt cú mèo ", Clothes.TypeNearBy));
        return list;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.recent:
                scrollToItem(0);
                break;
            case R.id.nearby:
                scrollToItem(7);
                break;
        }
    }

    private void scrollToItem(int index) {
        if(gridLayoutManager == null)
        {
            return;
        }
        gridLayoutManager.scrollToPositionWithOffset(index,0);
    }
}


