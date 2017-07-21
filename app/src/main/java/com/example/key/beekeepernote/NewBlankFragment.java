package com.example.key.beekeepernote;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.key.beekeepernote.database.Apiary;
import com.example.key.beekeepernote.database.BeeColony;
import com.example.key.beekeepernote.database.BeeFrame;
import com.example.key.beekeepernote.database.Beehive;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

import java.util.ArrayList;
import java.util.List;


/**
 *
 */
@EFragment
public class NewBlankFragment extends Fragment {
    View view;
    EditText nameApiary;
    EditText numberBeehive;
    String nameApiaryString;
    int numberBeehiveInt = 0;
    public NewBlankFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_new_blank, container, false);
        nameApiary = (EditText)view.findViewById(R.id.nameApiary);
        numberBeehive = (EditText)view.findViewById(R.id.numberBeehive);
        Button buttonCreateNewApiary = (Button)view.findViewById(R.id.buttonCreateNewApiary);
        buttonCreateNewApiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonCreateNewApiaryWasClicked(nameApiaryString = nameApiary.getText().toString());
            }
        });
        return view;
    }

    void buttonCreateNewApiaryWasClicked(String name){ ;
        if (name != null){
            numberBeehiveInt = Integer.parseInt(numberBeehive.getText().toString());

            BeeFrame beeBox = new BeeFrame();
            beeBox.setNoteFieldBox("skskjf");
            beeBox.setShapeBox(3);
            beeBox.setTypeBox(1);

            BeeFrame beeBox1 = new BeeFrame();
            beeBox1.setNoteFieldBox("skskjf");
            beeBox1.setShapeBox(3);
            beeBox1.setTypeBox(1);

            BeeFrame beeBox2 = new BeeFrame();
            beeBox2.setNoteFieldBox("skskjf");
            beeBox2.setShapeBox(3);
            beeBox2.setTypeBox(1);
            List<BeeFrame> beeFrames = new ArrayList<>();
            beeFrames.add(beeBox);
            beeFrames.add(beeBox1);
            beeFrames.add(beeBox2);


            BeeColony BeeColony = new BeeColony();
            BeeColony.setHaveFood(true);
            BeeColony.setNoteBeeColony("kdjfjsd");
            BeeColony.setOutput("lsfkdk");
            BeeColony.setQueen(true);
            BeeColony.setRiskOfSwaddling(true);
            BeeColony.setWorm(true);
            BeeColony.setBeeFrames(beeFrames);

            List<BeeColony> BeeColonyList = new ArrayList<>();
            BeeColonyList.add(BeeColony);


            Beehive beehive = new Beehive();
            beehive.setFounded(1209939);
            beehive.setNameBeehive("fkjdsfkdk");
            beehive.setNoteBeehive("dkfsdlkj;k");
            beehive.setTypeBeehive(1);
            beehive.setBeeColonies(BeeColonyList);

            Beehive beehive1 = new Beehive();
            beehive1.setFounded(1209934449);
            beehive1.setNameBeehive("fkjdsfkfdfdk");
            beehive1.setNoteBeehive("dkfsdlkfdsfj;k");
            beehive1.setTypeBeehive(2);
            beehive1.setBeeColonies(BeeColonyList);

            List<Beehive> beehiveList = new ArrayList<>();
            if (numberBeehiveInt == 0) {
                beehiveList.add(beehive);
            }else {
                for (int i = 0; i<= numberBeehiveInt;i++){
                    beehiveList.add(beehive);
                }
            }


            Apiary apiary = new Apiary();
            apiary.setLocationApiary("flfsdldlk");
            apiary.setNameApiary("nikolka");
            apiary.setNoteApiary("kdslfsdlk");
            apiary.setBeehives(beehiveList);

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference();
            myRef.child("apiary").child(nameApiaryString).setValue(apiary);


        }
    }

}
