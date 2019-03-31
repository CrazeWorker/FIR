package com.bean;

public class TestAdmin {
    private int testId;
    private String testName;

    @Override
    public String toString() {
        return "TestAdmin{" +
                "testId=" + testId +
                ", testName='" + testName + '\'' +
                '}';
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }
}
