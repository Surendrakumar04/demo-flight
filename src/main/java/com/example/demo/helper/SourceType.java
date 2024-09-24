package com.example.demo.helper;

import com.example.demo.model.datamodel.SearchQuery;
import com.example.demo.sources.AbstractSearchFactory;
import com.example.demo.sources.indigo.IndigoSearchFactory;
import com.example.demo.sources.spicejet.SpiceJetSearchFactory;

public enum SourceType {

    INDIGO(1){

        @Override
        public AbstractSearchFactory getFactoryInstance(SearchQuery searchQuery) {
            AbstractSearchFactory factory = ContextProvider.applicationContext.getBean(IndigoSearchFactory.class);
            factory.setSearchQuery(searchQuery);
            return factory;
        }
    },
    SPICE_JET(2){

        @Override
        public AbstractSearchFactory getFactoryInstance(SearchQuery searchQuery) {
            AbstractSearchFactory factory = ContextProvider.applicationContext.getBean(SpiceJetSearchFactory.class);
            factory.setSearchQuery(searchQuery);
            return factory;
        }
    };;

    private int sourceId;

    SourceType(int sourceId) {
    }

    public  static  SourceType getSourceType(int sourceId) {
        for(SourceType sourceType : SourceType.values()) {
            if(sourceType.sourceId == sourceId) {
                return sourceType;
            }
        }
        return null;
    }


    public abstract AbstractSearchFactory getFactoryInstance(SearchQuery searchQuery);
}
