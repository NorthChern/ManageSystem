<template>
  <div>

    <el-card class="box-card">

      <el-input v-model="query.username" style="width: 200px" placeholder="请输入用户姓名" clearable></el-input>
      &nbsp;&nbsp;
      <el-button type="primary" @click="getUserList()">查询</el-button>
      <el-button type="primary">新增</el-button>

      <el-table :data="tableData" style="width: 100%">
        <el-table-column prop="id" label="id"></el-table-column>
        <el-table-column prop="username" label="姓名"></el-table-column>
        <el-table-column prop="gender" label="性别"></el-table-column>
        <el-table-column prop="age" label="年龄"></el-table-column>
        <el-table-column prop="phone" label="电话号"></el-table-column>
        <el-table-column prop="email" label="邮箱"></el-table-column>
        <el-table-column prop="department" label="部门"></el-table-column>
        <el-table-column prop="joinDate" label="入职日期"></el-table-column>
        <el-table-column prop="avatar" label="头像"></el-table-column>
        <el-table-column prop="idnumber" label="身份证号"></el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button
                size="mini"
                @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
            <el-button
                size="mini"
                type="danger"
                @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>

      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="this.query.page"
          :page-sizes="[5, 10, 20, 30]"
          :page-size="this.query.size"
          layout="total, sizes, prev, pager, next, jumper"
          :total="this.total">
      </el-pagination>

    </el-card>

  </div>
</template>

<script>

export default {
  name: 'HomeView',
  data(){
    return {
      query: {
        page: 1,
        size: 5,
        username: ""
      },
      total:0,
      currentPage: 1,
      tableData: []
    }
  },
  methods: {
    handleEdit(index, row) {
      console.log(index, row);
    },
    handleDelete(index, row) {
      console.log(index, row);
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.query.size = val;
      this.getUserList();
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.query.page = val;
      this.getUserList();
    },
    getUserList() {
      this.axios.get("http://localhost:9090/user/getList",{
        params:{
          username: this.query.username,
          page:this.query.page,
          size:this.query.size
        }
      }).then((resp) => {
        console.log(resp)
        this.tableData = resp.data.content.list;
        this.total = resp.data.content.total
      })
    }
  },
  //页面渲染时加载数据
  created() {
    this.getUserList();
  }
}
</script>
