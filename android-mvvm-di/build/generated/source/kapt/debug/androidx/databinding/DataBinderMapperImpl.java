package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.dev.anhnd.android_mvvm_di.DataBinderMapperImpl());
  }
}
