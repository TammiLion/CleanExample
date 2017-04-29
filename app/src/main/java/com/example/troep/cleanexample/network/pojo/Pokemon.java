package com.example.troep.cleanexample.network.pojo;

import java.util.List;

/**
 * Created by troep on 4/29/17.
 */

public class Pokemon {

    public int id;
    public String name;
    public List<Stats> stats;

    public class Stats {

        public int base_stat;
        public int effort;
        public Stat stat;

        public class Stat {

            public String name;
            public String url;

        }

    }

}
