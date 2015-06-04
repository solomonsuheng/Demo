package zhihu;

import java.util.*;

/**
 * Created by Suheng on 6/3/15.
 */
public class problem2 {
    static Map<String, Integer> problemList = new HashMap<String, Integer>();
    static Map<String, List<Integer>> studentList = new HashMap<String, List<Integer>>();
    static int[] studentRank = new int[1000];

    public static void main(String[] args) {
        init();//初始化问题和学生
        randomSendProblemToStudent();//随机派送问题给学生
        int[] problemDifficult = getDifficult();
        //对题目的难度进行排序，题目的难度和它自身被作对的次数成反比，所以通过升序排序最靠前的就是最难的
        TreeMap<Integer, List<String>> problemDifficultRank = problemRank(problemDifficult);
        System.out.println(problemDifficultRank);

        //对学生的水平排序与题目同理
        System.out.println("---------分割线---------");
        //做对题目越多的，越厉害
        TreeMap<Integer, List<String>> studentRankShow = studentRankSolve();
        System.out.println(studentRankShow);
    }

    //对学生的水平进行排序
    public static TreeMap<Integer, List<String>> studentRankSolve() {
        TreeMap<Integer, List<String>> studentRankShow = new TreeMap<Integer, List<String>>();
        for (int i = 0; i < studentRank.length; i++) {
            if (studentRankShow.containsKey(studentRank[i])) {
                studentRankShow.get(studentRank[i]).add("#" + (i + 1));
            } else {
                List<String> list = new ArrayList<String>();
                list.add(("#" + (i + 1)));
                studentRankShow.put(studentRank[i], list);
            }
        }

        return studentRankShow;
    }


    //对问题的难易程度进行排序
    public static TreeMap<Integer, List<String>> problemRank(int[] problemDifficult) {
        TreeMap<Integer, List<String>> problemDifficultRank = new TreeMap<Integer, List<String>>();
        for (int i = 0; i < problemDifficult.length; i++) {
            if (problemDifficultRank.containsKey(problemDifficult[i])) {
                problemDifficultRank.get(problemDifficult[i]).add("#" + (i + 1));
            } else {
                List<String> list = new ArrayList<String>();
                list.add(("#" + (i + 1)));
                problemDifficultRank.put(problemDifficult[i], list);
            }
        }
        return problemDifficultRank;
    }

    //对问题的解答情况进行统计
    public static int[] getDifficult() {
        int[] problemDifficult = new int[1000];
        //遍历所有学生的答题情况对problemDifficult进行赋值
        for (int i = 1; i < 1000; i++) {
            int countOfRightProblem = checkRight(studentList.get("#" + i), problemDifficult);
            studentRank[i] = countOfRightProblem;
        }
        return problemDifficult;
    }

    //这里判断学生做题是否做对使用一个随机函数（0-100）如果获得的数字大于50则做对，否则做错
    public static int checkRight(List<Integer> list, int[] problemDifficult) {
        int countOfRightProblem = 0;
        for (int i : list) {
            if (Math.random() * 100 > 50) {
                //做对了
                problemDifficult[i - 1]++;
                countOfRightProblem++;

            } else {
                //做错了
            }
        }
        return countOfRightProblem;

    }

    //随机分发题目给学生，每人分配10个题目（分配保证不均匀）
    public static void randomSendProblemToStudent() {
        for (int i = 1; i <= 1000; i++) {
            for (int j = 0; j < 10; j++) {
                studentList.get("#" + i).add(randomProblem());
            }
        }
    }

    //用于获取随机的问题，为了防止题目分配不均匀，使用一个<k,v>来存储题目和题目出现的次数，如果题目的次数多于50次，就让重新选择题目
    public static int randomProblem() {
        boolean flag = true;
        int randomNum = (int) ((Math.random() * 1000) + 1);//从1-1000题中随机选取一个
        while (flag) {
            if (problemList.get("#" + randomNum).intValue() < 50) {
                problemList.put("#" + randomNum, problemList.get("#" + randomNum).intValue() + 1);
                flag = false;
            } else {
                randomNum = (int) ((Math.random() * 1000) + 1);
            }
        }
        return randomNum;
    }

    //初始化
    public static void init() {
        //初始化problemList
        for (int i = 1; i <= 1000; i++) {
            problemList.put("#" + i, 0);
        }

        //初始化student
        for (int i = 1; i <= 1000; i++) {
            studentList.put("#" + i, new ArrayList<Integer>());
        }
    }
}
