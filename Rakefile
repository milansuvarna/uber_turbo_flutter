require 'fileutils'
require 'allure-rspec'

task :run_minitest do
  sh 'ruby minitest/ucs_minitest.rb'
end

task :open_report_minitest do
  file_path = "#{Dir.pwd}/test/html_reports/index.html"
  sh "open -a 'Google Chrome' '#{file_path}'"
end

task :rspec do
  sh 'rspec spec --format AllureRspecFormatter'
end

task :generate_report_rspec do
  sh 'allure generate report --clean -o report/allure-report'
end

task :open_report_allure do
  sh `allure open report/allure-report`
end

task :clean_folder do
  folder_report_allure = "#{Dir.pwd}/report"
  folder_report_minitest = "#{Dir.pwd}/test"
  FileUtils.rm_rf(Dir.glob("#{folder_report_allure}/*"))
  FileUtils.rm_rf(Dir.glob("#{folder_report_minitest}"))
end
