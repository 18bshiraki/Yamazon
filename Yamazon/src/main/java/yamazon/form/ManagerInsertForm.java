package yamazon.form;

public class ManagerInsertForm {
	/*
	 * 登録画面用フォーム
	 */

		private Integer managerId;


		private String managerName;


		private String managerPassword;

		private String confirmPassword;

		public Integer getManagerId() {
			return managerId;
		}

		public void setManagerId(Integer managerId) {
			this.managerId = managerId;
		}

		public String getManagerName() {
			return managerName;
		}

		public void setName(String managerName) {
			this.managerName = managerName;
		}

		public String getManagerPassword() {
			return managerPassword;
		}

		public void setPassword(String managerPassword) {
			this.managerPassword = managerPassword;
		}

		public String getConfirmPassword() {
			return confirmPassword;
		}

		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}

		public boolean isEmpty() {
			return (managerName == null || managerName.isEmpty())
					&& (managerPassword == null || managerPassword.isEmpty());
		}

	}


