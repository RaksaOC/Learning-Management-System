package main.java.com.lms.managers.layer3.edit_entity_manager.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CambodiaAdministrative {
    // stores data for edits and stuff

    private ArrayList<String> provinces = new ArrayList<>();
    private Map<String, ArrayList<String>> districts = new HashMap<>();
    private Map<String, ArrayList<String>> communes = new HashMap<>();

    public void fillAddressData() {
        // Provinces
        provinces.add("Phnom Penh");
        provinces.add("Siem Reap");
        provinces.add("Battambang");
        provinces.add("Kampong Cham");
        provinces.add("Kampot");
        provinces.add("Preah Sihanouk");
        provinces.add("Takeo");
        provinces.add("Kandal");
        provinces.add("Koh Kong");
        provinces.add("Kratie");
        provinces.add("Mondulkiri");
        provinces.add("Ratanakiri");
        provinces.add("Stung Treng");
        provinces.add("Svay Rieng");
        provinces.add("Tboung Khmum");
        provinces.add("Oddar Meanchey");
        provinces.add("Pailin");
        provinces.add("Pursat");
        provinces.add("Prey Veng");
        provinces.add("Kampong Thom");
        provinces.add("Kampong Speu");
        provinces.add("Battambang");
        provinces.add("Banteay Meanchey");

        districts.put("Phnom Penh", new ArrayList<>(java.util.Arrays.asList(
                "Chamkar Mon",
                "Daun Penh",
                "Toul Kork",
                "Sen Sok",
                "Meanchey",
                "Por Sen Chey",
                "Russey Keo",
                "Chbar Ampov",
                "Kamboul",
                "Dangkor",
                "Prek Pnov"
        )));

        // Districts for Siem Reap
        districts.put("Siem Reap", new ArrayList<>(java.util.Arrays.asList(
                "Siem Reap",
                "Banteay Srei",
                "Pouk",
                "Srei Snam",
                "Angkor",
                "Chong Kneas",
                "Kouk Chak",
                "Sala Kamraeuk",
                "Svay Dangkum",
                "Tonle Sap"
        )));

        // Districts for Battambang
        districts.put("Battambang", new ArrayList<>(java.util.Arrays.asList(
                "Battambang",
                "Thmar Koul",
                "Bavel",
                "Rattanak Mondol",
                "Moung Russey",
                "Sangke",
                "Kampong Luong",
                "Pailin",
                "Samlot",
                "Kamrieng"
        )));


//        // Districts
//        districts.put("Phnom Penh", new ArrayList<>(java.util.Arrays.asList("Chamkar Mon", "Daun Penh", "Toul Kork", "Sen Sok")));
//        districts.put("Siem Reap", new ArrayList<>(java.util.Arrays.asList("Siem Reap", "Banteay Srei", "Pouk", "Srei Snam")));
//        districts.put("Battambang", new ArrayList<>(java.util.Arrays.asList("Battambang", "Thmar Koul", "Bavel", "Rattanak Mondol")));
//        districts.put("Kandal", new ArrayList<>(java.util.Arrays.asList("Takhmao", "Kien Svay", "Sa’ang")));
//
//        // Communes
//        communes.put("Chamkar Mon", new ArrayList<>(java.util.Arrays.asList("Boeung Keng Kang", "Tonle Bassac", "Toul Tompong")));
//        communes.put("Daun Penh", new ArrayList<>(java.util.Arrays.asList("Phsar Thmei", "Wat Phnom", "Srah Chak")));
//        communes.put("Siem Reap", new ArrayList<>(java.util.Arrays.asList("Svay Dangkum", "Sala Kamraeuk", "Kouk Chak")));
//        communes.put("Takhmao", new ArrayList<>(java.util.Arrays.asList("Koh Dach", "Prek Ho", "Dei Edth")));
    }

    public ArrayList<String> getProvinces() {
        return provinces;
    }
    public Map<String, ArrayList<String>> getDistricts() {
        return districts;
    }
    public Map<String, ArrayList<String>> getCommunes() {
        return communes;
    }
}