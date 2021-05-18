package com.dev.anhnd.mybase.utils.clean_architecture

sealed class Failure {

    object NetworkConnection :Failure()
    object ServerError : Failure()

    abstract class FeatureFailure : Failure()
}