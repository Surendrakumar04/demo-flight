package com.example.demo.base;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

@Setter
@Service
public abstract class ServiceHandler<T, RT extends BaseResponse> {
    @Getter
    protected T request;
    protected RT response;

    public ServiceHandler() {
    }

    public void initData(T request, RT response) {
        this.request = request;
        this.response = response;
    }

    public RT getResponse() throws Exception {
        this.beforeProcess(); // can be used to initialize any required data before proceeding to search
        if (CollectionUtils.isEmpty(this.response.getErrors())) {
            this.process(); // call will go to search manager if no errors
            if (CollectionUtils.isEmpty(this.response.getErrors())) {
                this.afterProcess();
            }
        }

        return this.response;
    }

    public abstract void beforeProcess() throws Exception;

    public abstract void process() throws Exception;

    public abstract void afterProcess() throws Exception;


}
