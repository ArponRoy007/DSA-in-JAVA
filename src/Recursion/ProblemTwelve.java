package Recursion;

public class ProblemTwelve {

    // স্ট্রিং থেকে ডুপ্লিকেট ক্যারেক্টার বাদ দিয়ে ইউনিক ক্যারেক্টার রাখার জন্য ফাংশন
    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
        // base case: পুরো স্ট্রিং শেষ হয়ে গেলে রেজাল্ট প্রিন্ট করে রিটার্ন করো
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        // বর্তমান ইন্ডেক্সের ক্যারেক্টার বের করলাম
        char currChar = str.charAt(idx);

        // যদি আগেই ক্যারেক্টারটি আছে (map এ true), তাহলে তাকে স্কিপ করব
        if (map[currChar - 'a'] == true) {
            // ডুপ্লিকেট ক্যারেক্টার, স্কিপ করে পরেরটার জন্য কল করলাম
            removeDuplicates(str, idx + 1, newStr, map);
        } else {
            // যদি প্রথমবার পাওয়া যায়, তাহলে map এ তাকে true করে দিলাম
            map[currChar - 'a'] = true;

            // newStr এ এই ক্যারেক্টার যোগ করে পরেরটার জন্য রিকার্সিভ কল করলাম
            removeDuplicates(str, idx + 1, newStr.append(currChar), map);
        }
    }

    public static void main(String[] args) {
        String str = "appnnacollege";
        removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
    }
}
