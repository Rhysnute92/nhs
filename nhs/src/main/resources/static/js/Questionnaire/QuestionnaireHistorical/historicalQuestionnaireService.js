import { fetchData, postData, putData } from "../../common/utils/apiUtility.js";

export class UserQuestionnaireService {
  constructor(baseUrl) {
    this.baseUrl = baseUrl || "/api/userQuestionnaires";
  }

  // Method to fetch completed UserQuestionnaires
  async getCompletedUserQuestionnaires() {
    try {
      const url = `${this.baseUrl}/user/completed`;
      const data = await fetchData(url);
      console.log("Completed UserQuestionnaires:", data);
      return data;
    } catch (error) {
      console.error("Error fetching completed UserQuestionnaires:", error);
      throw error;
    }
  }
}
