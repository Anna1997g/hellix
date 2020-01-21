package com.example.taskexample.room;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.taskexample.network.entities.Metadatum;

import java.util.List;

public class MetadatumDBRepository {
    private MetadatumDao metadatumDao;
    private LiveData<List<Metadatum>> allResults;

    public MetadatumDBRepository(Application application) {
        metadatumDao = MetadatumDatabase.getInstance(application).metadatumDao();
        allResults = metadatumDao.getAllItems();
    }

    public void insert(Metadatum metadatum) {
        new InsertAsyncTask(metadatumDao).execute(metadatum);

    }

    public void update(Metadatum metadatum) {
        new UpdateItemAsyncTask(metadatumDao).execute(metadatum);
    }

    public void delete(Metadatum metadatum) {
        new DeleteAsyncTask(metadatumDao).execute(metadatum);
    }

    public void deleteAll() {
        new DeleteAllAsyncTask(metadatumDao).execute();
    }

    public LiveData<List<Metadatum>> getAllResults() {
        new GetAllItemsAsyncTask(metadatumDao).execute();
        return allResults;
    }

    public void insertOrders(List<Metadatum> metadatumList) {
        new InsertOrdersAsyncTask(metadatumDao).execute(metadatumList);
    }

    static class InsertAsyncTask extends AsyncTask<Metadatum, Void, Void> {
        private MetadatumDao metadatumDao;

        InsertAsyncTask(MetadatumDao metadatumDao) {
            this.metadatumDao = metadatumDao;
        }

        @Override
        protected Void doInBackground(Metadatum... resultItems) {
            metadatumDao.insert(resultItems[0]);
            return null;
        }
    }


    static class UpdateItemAsyncTask extends AsyncTask<Metadatum, Void, Void> {
        private MetadatumDao metadatumDao;

        UpdateItemAsyncTask(MetadatumDao metadatumDao) {
            this.metadatumDao = metadatumDao;
        }

        @Override
        protected Void doInBackground(Metadatum... resultItems) {
            metadatumDao.update(resultItems[0].getSeen(), resultItems[0].getId());
            return null;
        }
    }


    static class InsertOrdersAsyncTask extends AsyncTask<List<Metadatum>, Void, Void> {
        private MetadatumDao metadatumDao;

        InsertOrdersAsyncTask(MetadatumDao metadatumDao) {
            this.metadatumDao = metadatumDao;
        }

        @SafeVarargs
        @Override
        protected final Void doInBackground(List<Metadatum>... lists) {
            metadatumDao.insertOrders(lists[0]);
            return null;
        }
    }


    static class DeleteAsyncTask extends AsyncTask<Metadatum, Void, Void> {
        private MetadatumDao metadatumDao;

        DeleteAsyncTask(MetadatumDao metadatumDao) {
            this.metadatumDao = metadatumDao;
        }

        @Override
        protected Void doInBackground(Metadatum... resultItems) {
            metadatumDao.delete(resultItems[0]);
            return null;
        }
    }


    static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private MetadatumDao metadatumDao;

        DeleteAllAsyncTask(MetadatumDao metadatumDao) {
            this.metadatumDao = metadatumDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            metadatumDao.deleteAll();
            return null;
        }
    }


    static class GetAllItemsAsyncTask extends AsyncTask<Void, Void, Void> {
        private MetadatumDao metadatumDao;

        GetAllItemsAsyncTask(MetadatumDao metadatumDao) {
            this.metadatumDao = metadatumDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            metadatumDao.getAllItems();
            return null;
        }
    }


}

