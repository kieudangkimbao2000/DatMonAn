package com.example.tmnn;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Item[] items;
    ListView _myList;
    Button btnDatMon;
    CustomListItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareDate();
        _myList = (ListView) findViewById(R.id.myList);
        adapter = new CustomListItemAdapter(this, R.layout.list_item_lnk_img, items);
        _myList.setAdapter(adapter);
        btnDatMon = (Button) findViewById(R.id.btnDatMon);
        btnDatMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n = 0;
                for(int i = 0; i < items.length; i++) {
                    if (items[i].isSelected()) {
                        n++;
                    }
                }
                if(n == 0){
                    Toast.makeText(MainActivity.this, "Chưa chọn món", Toast.LENGTH_SHORT).show();
                }else{
                    Item[] itemsChecked = new Item[n];
                    int j = 0;
                    for(int i = 0; i < items.length; i++){
                        if(items[i].isSelected()){
                            itemsChecked[j] = items[i];
                            j++;
                        }
                    }

                    ItemsList itemsList = new ItemsList(itemsChecked);
                    Intent intent = new Intent(MainActivity.this, ChotDonActivity.class);
                    intent.putExtra("ItemsChecked", itemsList);
                    startActivity(intent);
                }
            }
        });

    }
    public void prepareDate(){
        items = new Item[10];
        items[0] = new Item(1, "Bún chả",
                "https://www.google.com/maps/place/Tr%C6%B0%E1%BB%9Dng+%C4%90%E1%BA%A1i+h%E1%BB%8Dc+S%C3%A0i+G%C3%B2n/@10.7600608,106.6809749,18.04z/data=!4m5!3m4!1s0x31752f1b7c3ed289:0xa06651894598e488!8m2!3d10.7599171!4d106.6822583",
                "An Dương Vương, phường 3, Quận 5, Thành phố Hồ Chí Minh",
                R.drawable.buncha,
                "Miếng chả nóng hổi được thả vào bát nước chấm chua ngọt được pha chế cầu kỳ được ăn cùng với bún và rau sống là hương vị tuyệt vời mà ai ăn một lần rồi cũng đều nhớ mãi hương vị ấy không thôi.",
                20000
        );
        items[1] = new Item(2, "Bánh mì kẹp thịt",
                "https://www.google.com/maps/place/Tr%C6%B0%E1%BB%9Dng+%C4%90%E1%BA%A1i+h%E1%BB%8Dc+S%C3%A0i+G%C3%B2n/@10.7600608,106.6809749,18.04z/data=!4m5!3m4!1s0x31752f1b7c3ed289:0xa06651894598e488!8m2!3d10.7599171!4d106.6822583",
                "An Dương Vương, phường 3, Quận 5, Thành phố Hồ Chí Minh",
                R.drawable.banhmithit,
                "Bánh mì Việt Nam ở mỗi vùng có cách làm nhân hương vị khác nhau nhưng chung quy lại đều là những chiếc bánh rất đầy đặn nhân, từ trứng, ruốc, thịt nướng, dăm bông, xúc xích đến pa tê, rau sống, nộm chua ngọt...",
                15000
        );
        items[2] = new Item(3, "Nem rán",
                "https://www.google.com/maps/place/Tr%C6%B0%E1%BB%9Dng+%C4%90%E1%BA%A1i+h%E1%BB%8Dc+S%C3%A0i+G%C3%B2n/@10.7600608,106.6809749,18.04z/data=!4m5!3m4!1s0x31752f1b7c3ed289:0xa06651894598e488!8m2!3d10.7599171!4d106.6822583",
                "An Dương Vương, phường 3, Quận 5, Thành phố Hồ Chí Minh",
                R.drawable.nemran,
                "Nem rán được làm từ nhiều loại nhân khác nhau, cũng gia giảm tùy kheo ẩm thực từng vùng miền nhưng ở đâu thì nem rán cũng được chế biến công phu, tinh tế. Nem rán có vị giòn của vỏ bánh đa nem, có hương vị ngon, ngọt, béo ngậy của thịt, rau, nấm hương, mộc nhĩ... được ăn kèm nước chấm và rau sống nên càng tạo nên vị ngon hoàn hảo.",
                10000
        );
        items[3] = new Item(4, "Chuối nếp nướng",
                "https://www.google.com/maps/place/Tr%C6%B0%E1%BB%9Dng+%C4%90%E1%BA%A1i+h%E1%BB%8Dc+S%C3%A0i+G%C3%B2n/@10.7600608,106.6809749,18.04z/data=!4m5!3m4!1s0x31752f1b7c3ed289:0xa06651894598e488!8m2!3d10.7599171!4d106.6822583",
                "An Dương Vương, phường 3, Quận 5, Thành phố Hồ Chí Minh",
                R.drawable.chuoinepnuong,
                "Chuối nếp nướng, món ăn dân giã mà bình dị nhưng đã được vinh danh và bình chọn là món ăn đường phố được yêu thích nhất tại hội chợ ẩm thực đường phố Singapore năm 2013.",
                10000
        );
        items[4] = new Item(5, "Cà phê trứng",
                "https://www.google.com/maps/place/Tr%C6%B0%E1%BB%9Dng+%C4%90%E1%BA%A1i+h%E1%BB%8Dc+S%C3%A0i+G%C3%B2n/@10.7600608,106.6809749,18.04z/data=!4m5!3m4!1s0x31752f1b7c3ed289:0xa06651894598e488!8m2!3d10.7599171!4d106.6822583",
                "An Dương Vương, phường 3, Quận 5, Thành phố Hồ Chí Minh",
                R.drawable.caphetrung,
                "Cà phê trứng của Việt Nam đứng đầu trong danh mục 17 loại cà phên nên uống khi du lịch thế giới trên trang mạng Buzzfeed. Đây là một loại thức uống có lẽ khá đặc biệt và mới lạ với du khách nước ngoài.",
                16000
        );
        items[5] = new Item(6, "Gỏi cuốn",
                "https://www.google.com/maps/place/Tr%C6%B0%E1%BB%9Dng+%C4%90%E1%BA%A1i+h%E1%BB%8Dc+S%C3%A0i+G%C3%B2n/@10.7600608,106.6809749,18.04z/data=!4m5!3m4!1s0x31752f1b7c3ed289:0xa06651894598e488!8m2!3d10.7599171!4d106.6822583",
                "An Dương Vương, phường 3, Quận 5, Thành phố Hồ Chí Minh",
                R.drawable.goicuon,
                "Nguyên liệu gồm vỏ bánh tráng, nhân là tôm, thịt, rau sống đem cuộn lại rồi chấm với nước chấm chua ngọt. Gỏi cuốn vừa đẹp mắt lại vừa ngon miệng nên khách nước ngoài khi thưởng thức món ăn này cũng rất hào hứng.",
                15000
        );
        items[6] = new Item(7, "Phở bò",
                "https://www.google.com/maps/place/Tr%C6%B0%E1%BB%9Dng+%C4%90%E1%BA%A1i+h%E1%BB%8Dc+S%C3%A0i+G%C3%B2n/@10.7600608,106.6809749,18.04z/data=!4m5!3m4!1s0x31752f1b7c3ed289:0xa06651894598e488!8m2!3d10.7599171!4d106.6822583",
                "An Dương Vương, phường 3, Quận 5, Thành phố Hồ Chí Minh",
                R.drawable.phobo,
                "Vị ngọt của nước dùng ninh từ xương lợn, xương bò, bánh phở mềm và thơm mùi gạo, thịt bò vừa chín tới, thêm chút hành ngò thái nhỏ tô điểm làm dậy thêm hương vị bát phở. Phở là món bình dân, ai cũng có thể ăn được từ tầng lớp bình dân cho đến người có điều kiện kinh tế.",
                30000
        );
        items[7] = new Item(8, "Bún riêu cua",
                "https://www.google.com/maps/place/Tr%C6%B0%E1%BB%9Dng+%C4%90%E1%BA%A1i+h%E1%BB%8Dc+S%C3%A0i+G%C3%B2n/@10.7600608,106.6809749,18.04z/data=!4m5!3m4!1s0x31752f1b7c3ed289:0xa06651894598e488!8m2!3d10.7599171!4d106.6822583",
                "An Dương Vương, phường 3, Quận 5, Thành phố Hồ Chí Minh",
                R.drawable.bunrieucua,
                "Nước dùng được nấu từ cua xay hoặc giã nhỏ lọc lấy thịt cùng với gạch cua, cà chua để có vị chua dịu, thanh thanh, ngọt và mát. Bún rối cùng với rau sống, đậu phụ rán vàng khiến cho bát bún riêu thêm thơm ngon, đậm đà hơn.",
                25000
        );
        items[8] = new Item(9, "Bánh xèo",
                "https://www.google.com/maps/place/Tr%C6%B0%E1%BB%9Dng+%C4%90%E1%BA%A1i+h%E1%BB%8Dc+S%C3%A0i+G%C3%B2n/@10.7600608,106.6809749,18.04z/data=!4m5!3m4!1s0x31752f1b7c3ed289:0xa06651894598e488!8m2!3d10.7599171!4d106.6822583",
                "An Dương Vương, phường 3, Quận 5, Thành phố Hồ Chí Minh",
                R.drawable.banhxeo,
                "Bánh xèo nổi tiếng ở vùng Nam Bộ nhưng hiện nay thì cũng đã có mặt ở khắp mọi miền đất nước và mỗi nơi lại có một hương vị thơm ngon đặc trưng.",
                20000
        );
        items[9] = new Item(10, "Bún bò Huế",
                "https://www.google.com/maps/place/Tr%C6%B0%E1%BB%9Dng+%C4%90%E1%BA%A1i+h%E1%BB%8Dc+S%C3%A0i+G%C3%B2n/@10.7600608,106.6809749,18.04z/data=!4m5!3m4!1s0x31752f1b7c3ed289:0xa06651894598e488!8m2!3d10.7599171!4d106.6822583",
                "An Dương Vương, phường 3, Quận 5, Thành phố Hồ Chí Minh",
                R.drawable.bunbohue,
                "Vị ngọt của nước dùng được ninh từ xương lợn, xương bò, thêm chút mắm ruốc, thịt bò, bún sợi, rau sống, hoa chuối thái sợi... tất cả hòa quyện lại tạo nên sự hấp dẫn của món ăn này.",
                20000
        );
    }
}