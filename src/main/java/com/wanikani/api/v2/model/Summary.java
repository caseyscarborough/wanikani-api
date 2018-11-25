package com.wanikani.api.v2.model;

import java.util.Date;
import java.util.List;

public class Summary {

    private Date nextReviewsAt;
    private List<SummaryReview> reviews;
    private List<SummaryLesson> lessons;

    public Date getNextReviewsAt() {
        return nextReviewsAt;
    }

    public void setNextReviewsAt(Date nextReviewsAt) {
        this.nextReviewsAt = nextReviewsAt;
    }

    public List<SummaryReview> getReviews() {
        return reviews;
    }

    public void setReviews(List<SummaryReview> reviews) {
        this.reviews = reviews;
    }

    public List<SummaryLesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<SummaryLesson> lessons) {
        this.lessons = lessons;
    }
}
