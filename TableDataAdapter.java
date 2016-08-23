public class EmpJobDataAdapter extends TableDataAdapter<EmployeeJob> {
        public EmpJobDataAdapter(Context context, List<EmployeeJob> data) {
            super(context, data);
        }

        @Override
        public View getCellView(int rowIndex, int columnIndex, ViewGroup parentView) {
            EmployeeJob rowJob = getItem(rowIndex);//empJobs.get(rowIndex);
            final TextView textView = new TextView(getContext());
            if (columnIndex == 0)
                textView.setPadding(20, 40, 5, 40);
            else
                textView.setPadding(15, 0, 5, 0);
            switch (columnIndex) {
                case 0:
                    textView.setText(rowJob.getJob(realm).Name);
                    break;
                case 1:
                    textView.setText(rowJob.JobStatus.Name);
                    break;
                case 2:
                    if (rowJob.isStarted() || rowJob.isComplete()) {
                        int unvarifiedDocs = 0;
                        if ((unvarifiedDocs = MiscStorage.countUnvarifiedDocs(rowJob, realm)) > 0) {
                            textView.setText(unvarifiedDocs + " docs pending");
                            textView.setBackgroundColor(Color.parseColor("#fbbc05"));
                            textView.setTextColor(Color.BLACK);
                        }
                    } else
                        textView.setText(rowJob.getShortDescription());
                    break;
            }
            return textView;
        }

    }