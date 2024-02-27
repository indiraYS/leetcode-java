package com.company.easy;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {

        StringBuilder sb = new StringBuilder();
        int cnt;
        int division = columnNumber;
        int left;
        while (division > 26) {
            cnt = division / 26;

            left = division % 26;

            if (left > 0) {
                sb.insert(0, getChr(left));
            } else {
                sb.insert(0, getChr(26));
                cnt--;
            }

            division = cnt;
        }

        sb.insert(0, getChr(division));

        return sb.toString();
    }

    private Character getChr(int num){
        switch (num) {
            case 1 : return 'A';
            case 2 : return 'B';
            case 3 : return 'C';
            case 4 : return 'D';
            case 5 : return 'E';
            case 6 : return 'F';
            case 7 : return 'G';
            case 8 : return 'H';
            case 9 : return 'I';
            case 10 : return 'J';
            case 11 : return 'K';
            case 12 : return 'L';
            case 13 : return 'M';
            case 14 : return 'N';
            case 15 : return 'O';
            case 16 : return 'P';
            case 17 : return 'Q';
            case 18 : return 'R';
            case 19 : return 'S';
            case 20 : return 'T';
            case 21 : return 'U';
            case 22 : return 'V';
            case 23 : return 'W';
            case 24 : return 'X';
            case 25 : return 'Y';
            default: return 'Z';
        }
    }

}
