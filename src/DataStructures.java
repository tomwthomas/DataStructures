public class DataStructures
{
    public static void main(String[] args)
    {

        // System.out.println("hello world!");

        // instantiate Hash Table Data Structure object
        HashTableDataStructure HTDS = new HashTableDataStructure();

        // Begin test cases for Hash Table Data Structure (HTDS)
        HTDS.addEntry("Bob", "Smith", "555-235-1111", "bsmith@somewhere.com");
        HTDS.addEntry("Jane", "Williams", "555-235-1112", "jw@something.com");
        HTDS.addEntry("Mohammed", "al-Salam", "555-235-1113", "mas@someplace.com");
        HTDS.addEntry("Pat", "Jones", "555-235-1114", "pjones@homesweethome.com");
        HTDS.addEntry("Billy", "Kidd", "555-235-1115", "billy_the_kid@nowhere.com");
        HTDS.addEntry("H.", "Houdini", "555-235-1116", "houdini@noplace.com");
        HTDS.addEntry("Jack", "Jones", "555-235-1117", "jjones@hill.com");
        HTDS.addEntry("Jill", "Jones", "555-235-1118", "jillj@hill.com");
        HTDS.addEntry("John", "Doe", "555-235-1119", "jdoe@somedomain.com");
        HTDS.addEntry("Jane", "Doe", "555-235-1120", "jdoe@somedomain.com");
        HTDS.lookupEntry("Pat", "Jones");
        HTDS.lookupEntry("Billy", "Kidd");
        HTDS.removeEntry("John", "Doe");
        HTDS.addEntry("Test", "Case", "555-235-1121", "Test_Case@testcase.com");
        HTDS.addEntry("Nadezhda", "Kanachekhovskaya", "555-235-1122", "dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
        HTDS.addEntry("Jo", "Wu", "555-235-1123", "wu@h.com");
        HTDS.addEntry("Millard", "Fillmore", "555-235-1124", "millard@theactualwhitehouse.us");
        HTDS.addEntry("Bob", "vanDyke", "555-235-1125", "vandyke@nodomain.com");
        HTDS.addEntry("Upside", "Down", "555-235-1126", "upsidedown@rightsideup.com");
        HTDS.lookupEntry("Jack", "Jones");
        HTDS.lookupEntry("Nadezhda", "Kanachekhovskaya");
        HTDS.removeEntry("Jill", "Jones");
        HTDS.removeEntry("John", "Doe");
        HTDS.lookupEntry("Jill", "Jones"); //  (What should happen if the “lookup” message doesn’t find the entry?)
        HTDS.lookupEntry("John", "Doe");
        // End test cases for Hash Table Data Structures (HTDS)


        // Begin test cases for Tree Data Structure (TDS)
//        Insert Bob Smith 555-235-1111 bsmith@somewhere.com
//        Insert Jane Williams 555-235-1112 jw@something.com
//        Insert Mohammed al-Salam 555-235-1113 mas@someplace.com
//        Insert Pat Jones 555-235-1114 pjones@homesweethome.com
//        Insert Billy Kidd 555-235-1115 billy_the_kid@nowhere.com
//        Insert H. Houdini 555-235-1116 houdini@noplace.com
//        Insert Jack Jones 555-235-1117 jjones@hill.com
//        Insert Jill Jones 555-235-1118 jillj@hill.com
//        Insert John Doe 555-235-1119 jdoe@somedomain.com
//        Insert Jane Doe 555-235-1120 jdoe@somedomain.com
//        Lookup Pat Jones
//        Lookup Billy Kidd
//        Delete John Doe
//        Insert Test Case 555-235-1121 Test_Case@testcase.com
//        Insert Nadezhda Kanachekhovskaya 555-235-1122 dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru
//        Insert Jo Wu 555-235-1123 wu@h.com
//        Insert Millard Fillmore 555-235-1124 millard@theactualwhitehouse.us
//        Insert Bob vanDyke 555-235-1125 vandyke@nodomain.com
//        Insert Upside Down 555-235-1126 upsidedown@rightsideup.com
//        Lookup Jack Jones
//        Lookup Nadezhda Kanachekhovskaya
//        Delete Jill Jones
//        Delete John Doe
//        Lookup Jill Jones (What should happen if the “lookup” message doesn’t find the entry?)
//        Lookup John Doe
        // end test cases for Tree Data Structure (TDS)

        // System.out.println("good bye world!");

    }
}